/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import org.opensearch.client.codegen.utils.JavaSourceParser;
import org.opensearch.client.codegen.utils.Strings;

public class ExistingOperation implements IOperation {
    private final OperationGroup operationGroup;
    private final String id;
    private final String description;
    private final Type type;
    private final Type responseType;
    private final boolean canBeSingleton;
    private final boolean hasAnyRequiredFields;

    public ExistingOperation(JavaSourceParser parser, CompilationUnit compilationUnit, ClassOrInterfaceDeclaration classDecl) {
        var packageName = compilationUnit.getPackageDeclaration().orElseThrow().getNameAsString();
        var className = classDecl.getNameAsString();

        var namespace = packageName.substring(Namespace.ROOT_PACKAGE.length());
        if (namespace.startsWith(".")) namespace = namespace.substring(1);
        if (namespace.isEmpty() || namespace.startsWith("core")) namespace = null;

        var operationName = Strings.toSnakeCase(className.substring(0, className.length() - "Request".length()));

        this.operationGroup = new OperationGroup(namespace, operationName);
        this.id = operationGroup.getName();
        this.description = classDecl.getJavadoc().map(doc -> doc.getDescription().toText()).orElse(null);

        var requestTypeParams = classDecl.getTypeParameters()
            .stream()
            .map(t -> Type.builder().name(t.getName().asString()).build())
            .toArray(Type[]::new);

        this.type = Type.builder().pkg(packageName).name(className).typeParams(requestTypeParams).build();

        var responseType = classDecl.getFieldByName("_ENDPOINT")
            .orElseThrow()
            .getCommonType()
            .asClassOrInterfaceType()
            .getTypeArguments()
            .orElseThrow()
            .get(1)
            .resolve();
        ResolvedReferenceTypeDeclaration responseTypeDecl;

        if (responseType.isWildcard()) {
            responseTypeDecl = parser.parseClass(packageName, className.replace("Request", "Response"))
                .getPrimaryType()
                .orElseThrow()
                .resolve();
        } else {
            responseTypeDecl = responseType.asReferenceType().getTypeDeclaration().orElseThrow();
        }

        var responseTypeParams = responseTypeDecl.getTypeParameters()
            .stream()
            .map(t -> Type.builder().name(t.getName()).build())
            .toArray(Type[]::new);

        this.responseType = Type.builder()
            .pkg(responseTypeDecl.getPackageName())
            .name(responseTypeDecl.getName())
            .typeParams(responseTypeParams)
            .build();
        this.canBeSingleton = classDecl.getFieldByName("_INSTANCE").isPresent();
        this.hasAnyRequiredFields = requestTypeParams.length > 0
            || responseTypeParams.length > 0
            || classDecl.getConstructorByParameterTypes("Builder")
                .map(
                    c -> c.getBody()
                        .getStatements()
                        .stream()
                        .filter(Statement::isExpressionStmt)
                        .map(Statement::asExpressionStmt)
                        .map(ExpressionStmt::getExpression)
                        .filter(Expression::isAssignExpr)
                        .map(Expression::asAssignExpr)
                        .map(AssignExpr::getValue)
                        .map(Expression::toString)
                        .anyMatch(e -> e.startsWith("ApiTypeHelper.requireNonNull") || e.startsWith("ApiTypeHelper.unmodifiableRequired"))
                )
                .orElse(false);
    }

    public OperationGroup getOperationGroup() {
        return operationGroup;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public Type getResponseType() {
        return responseType;
    }

    public boolean canBeSingleton() {
        return canBeSingleton;
    }

    public boolean hasAnyRequiredFields() {
        return hasAnyRequiredFields;
    }
}
