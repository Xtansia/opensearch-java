/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.utils.JavaSourceParser;
import org.opensearch.client.codegen.utils.Lists;
import org.opensearch.client.codegen.utils.Strings;

public class Namespace {
    public static final String ROOT_PACKAGE = Types.Client.OpenSearch.PACKAGE;

    private static final Logger LOGGER = LogManager.getLogger();
    private final Namespace parent;
    private final String name;
    private final Map<String, Namespace> children = new TreeMap<>();
    private final Map<String, IOperation> operations = new TreeMap<>();
    private final List<Shape> shapes = new ArrayList<>();

    public Namespace() {
        this(null, "");
    }

    private Namespace(Namespace parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public void addOperation(RequestShape operation) {
        addOperation((IOperation) operation);
        addShape(operation);
    }

    private void addOperation(IOperation operation) {
        operations.put(operation.getId(), operation);
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public String getPackageName() {
        return parent != null ? parent.getPackageName() + "." + getPackageNamePart() : ROOT_PACKAGE;
    }

    private String getPackageNamePart() {
        return name;
    }

    @Nonnull
    public Namespace child(@Nullable String name) {
        if (Strings.isNullOrEmpty(name)) {
            return this;
        }

        int idx = name.indexOf('.');
        var childName = idx >= 0 ? name.substring(0, idx) : name;
        var grandChildName = idx >= 0 ? name.substring(idx + 1) : null;

        Namespace child = children.computeIfAbsent(childName, n -> new Namespace(this, n));
        return grandChildName == null ? child : child.child(grandChildName);
    }

    public void collectExistingOperations(JavaSourceParser parser) {
        var pkg = getPackageName();

        for (var subPkg : parser.listSubPackages(pkg)) {
            if (isRoot() && "generic".equals(subPkg)) continue;
            child(subPkg).collectExistingOperations(parser);
        }

        for (var compilationUnit : parser.parsePackage(pkg)) {
            var typeDecl = compilationUnit.getPrimaryType().orElse(null);
            if (typeDecl == null || !typeDecl.isClassOrInterfaceDeclaration()) continue;
            var classDecl = typeDecl.asClassOrInterfaceDeclaration();
            if (classDecl.isInterface() || !classDecl.getNameAsString().endsWith("Request")) continue;
            LOGGER.info("Found existing request class: {}", classDecl.getFullyQualifiedName().orElseThrow());
            addOperation(new ExistingOperation(parser, compilationUnit, classDecl));
        }
    }

    public boolean render(ShapeRenderingContext ctx) throws RenderException {
        var childClientsToGenerate = new ArrayList<Namespace>();

        for (Namespace child : children.values()) {
            if (child.render(ctx.forSubDir(child.getPackageNamePart()))) {
                childClientsToGenerate.add(child);
            }
        }

        for (Shape shape : shapes) {
            shape.render(ctx);
        }

        var operationsToRender = getOperationsForClient();

        if (childClientsToGenerate.isEmpty() && operationsToRender.isEmpty()) return false;

        new Client(this, false, childClientsToGenerate, operationsToRender).render(ctx);
        new Client(this, true, childClientsToGenerate, operationsToRender).render(ctx);

        return true;
    }

    private Collection<IOperation> getOperationsForClient() {
        if (isRoot()) {
            var operations = new TreeMap<String, IOperation>();
            child("core").collectAllOperations(operations);
            return operations.values();
        }

        if (isUnderCore()) return Collections.emptyList();

        return operations.values();
    }

    private void collectAllOperations(Map<String, IOperation> operations) {
        operations.putAll(this.operations);
        for (var child : this.children.values()) {
            child.collectAllOperations(operations);
        }
    }

    private boolean isRoot() {
        return Strings.isNullOrEmpty(this.name);
    }

    private boolean isUnderCore() {
        if (parent == null) return false;
        if (parent.isRoot() && "core".equals(name)) return true;
        return parent.isUnderCore();
    }

    private String getClientClassName(boolean async) {
        return "OpenSearch" + Strings.toPascalCase(name) + (async ? "Async" : "") + "Client";
    }

    private Type getClientType(boolean async) {
        return Type.builder().pkg(getPackageName()).name(getClientClassName(async)).build();
    }

    private static class Client extends Shape {
        private final boolean async;
        private final Collection<Namespace> children;
        private final Collection<IOperation> operations;

        private Client(Namespace parent, boolean async, Collection<Namespace> children, Collection<IOperation> operations) {
            super(parent, parent.getClientClassName(async), null, "Client for the " + parent.name + " namespace.");
            this.async = async;
            this.children = children;
            this.operations = operations;
        }

        @Override
        public Type getExtendsType() {
            return Types.Client.ApiClient(Types.Client.Transport.OpenSearchTransport, getType());
        }

        public String getName() {
            return parent.name;
        }

        public Collection<ClientRef> getChildren() {
            return Lists.map(children, n -> new ClientRef(n, async));
        }

        public Collection<IOperation> getOperations() {
            return operations;
        }

        public boolean isAsync() {
            return this.async;
        }

        private static class ClientRef {
            private final Type type;
            private final String name;

            public ClientRef(Namespace namespace, boolean async) {
                this.type = namespace.getClientType(async);
                this.name = namespace.name;
            }

            public Type getType() {
                return type;
            }

            public String getName() {
                return name;
            }
        }

    }

}
