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
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.model.types.Type;
import org.opensearch.client.codegen.model.types.TypeRef;
import org.opensearch.client.codegen.model.types.Types;
import org.opensearch.client.codegen.transformer.overrides.ShouldGenerate;

public class DelegatedShape extends Shape {
    @Nonnull
    private final TypeRef delegatedType;
    @Nonnull
    private final Field valueBodyField;

    public DelegatedShape(
        Namespace parent,
        String className,
        String typedefName,
        String description,
        ShouldGenerate shouldGenerate,
        TypeRef delegatedType
    ) {
        super(parent, className, typedefName, description, shouldGenerate);
        this.delegatedType = Objects.requireNonNull(delegatedType, "delegatedType cannot be null");
        tryAddReference(ReferenceKind.Field, delegatedType);
        this.valueBodyField = Field.builder()
            .withName("valueBody")
            .withType(delegatedType)
            .withDescription("Response value.")
            .withRequired(true)
            .build();
    }

    @Nonnull
    public TypeRef getDelegatedType() {
        return delegatedType;
    }

    public Collection<Field> getFields() {
        var fields = new ArrayList<Field>();
        fields.add(valueBodyField);
        fields.addAll(getTypeParameterSerializerFields());
        fields.sort(Comparator.comparing(Field::getName));
        return fields;
    }

    public boolean hasFields() {
        return true;
    }

    public Collection<Field> getHashableFields() {
        return List.of(valueBodyField);
    }

    @Override
    public Collection<TypeRef> getAnnotations() {
        var annotations = new ArrayList<>(super.getAnnotations());
        annotations.add(Types.Client.Json.JsonpDeserializable);
        return annotations;
    }

    @Override
    public Collection<TypeRef> getImplementsTypes() {
        var types = new ArrayList<>(super.getImplementsTypes());
        types.add(Types.Client.Json.PlainJsonSerializable);
        types.add(Types.Client.Util.ToCopyableBuilder(getSelfType().getBuilderType(), getSelfType()));
        return types;
    }

    public Collection<ObjectShapeBase.BuilderSetter> getConcreteBuilderSetters() {
        var builderT = Type.builder().withName("Builder").withTypeParameters(getSelfType().getTypeParams()).build();
        return getFields().stream().map(f -> new ObjectShapeBase.BuilderSetter(builderT, f)).collect(Collectors.toList());
    }
}
