/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.utils;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;

public class JavaSourceParser {
    @Nonnull
    private final File sourceDir;
    @Nonnull
    private final JavaParser parser;

    private JavaSourceParser(@Nonnull Builder builder) {
        Objects.requireNonNull(builder, "builder must not be null");

        this.sourceDir = Objects.requireNonNull(builder.sourceDir, "sourceDir must not be null");

        var typeSolver = new CombinedTypeSolver();
        typeSolver.add(new ReflectionTypeSolver());
        typeSolver.add(new JavaParserTypeSolver(sourceDir));

        var symbolSolver = new JavaSymbolSolver(typeSolver);

        var parserConfig = new ParserConfiguration().setLanguageLevel(ParserConfiguration.LanguageLevel.JAVA_8)
            .setAttributeComments(true)
            .setDoNotAssignCommentsPrecedingEmptyLines(false)
            .setIgnoreAnnotationsWhenAttributingComments(true)
            .setSymbolResolver(symbolSolver);

        this.parser = new JavaParser(parserConfig);
    }

    @Nonnull
    public CompilationUnit parse(File file) {
        try {
            return this.parser.parse(file).getResult().orElseThrow();
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse " + file, e);
        }
    }

    @Nonnull
    public CompilationUnit parseClass(String pkg, String className) {
        return parse(new File(packageDir(pkg), className + ".java"));
    }

    @Nonnull
    public List<CompilationUnit> parsePackage(String pkg) {
        return Arrays.stream(listPackage(pkg))
            .filter(f -> f.isFile() && f.getName().endsWith(".java"))
            .map(this::parse)
            .collect(Collectors.toList());
    }

    @Nonnull
    public List<String> listSubPackages(String pkg) {
        return Arrays.stream(listPackage(pkg)).filter(File::isDirectory).map(File::getName).collect(Collectors.toList());
    }

    @Nonnull
    private File[] listPackage(String pkg) {
        var files = packageDir(pkg).listFiles();
        return files != null ? files : new File[0];
    }

    @Nonnull
    private File packageDir(String pkg) {
        return new File(this.sourceDir, pkg.replace('.', File.separatorChar));
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private File sourceDir;

        @Nonnull
        public Builder withSourceDir(@Nonnull File sourceDir) {
            this.sourceDir = Objects.requireNonNull(sourceDir, "sourceDir must not be null");
            return this;
        }

        @Nonnull
        public JavaSourceParser build() {
            return new JavaSourceParser(this);
        }
    }
}
