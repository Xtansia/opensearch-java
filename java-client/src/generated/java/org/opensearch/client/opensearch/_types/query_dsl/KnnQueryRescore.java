/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.json.UnionDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;

// typedef: _types.query_dsl.KnnQueryRescore

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class KnnQueryRescore implements TaggedUnion<KnnQueryRescore.Kind, Object>, PlainJsonSerializable {
    /**
     * {@link KnnQueryRescore} variant kinds.
     */
    public enum Kind {
        Context,
        Enable
    }

    private final Kind _kind;
    private final Object _value;

    @Override
    public final Kind _kind() {
        return _kind;
    }

    @Override
    public final Object _get() {
        return _value;
    }

    private KnnQueryRescore(Kind kind, Object value) {
        this._kind = kind;
        this._value = value;
    }

    private KnnQueryRescore(Builder builder) {
        this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
        this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");
    }

    public static KnnQueryRescore of(Function<KnnQueryRescore.Builder, ObjectBuilder<KnnQueryRescore>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Is this variant instance of kind {@code context}?
     */
    public boolean isContext() {
        return _kind == Kind.Context;
    }

    /**
     * Get the {@code context} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code context} kind.
     */
    public RescoreContext context() {
        return TaggedUnionUtils.get(this, Kind.Context);
    }

    /**
     * Is this variant instance of kind {@code enable}?
     */
    public boolean isEnable() {
        return _kind == Kind.Enable;
    }

    /**
     * Get the {@code enable} variant value.
     *
     * @throws IllegalStateException if the current variant is not the {@code enable} kind.
     */
    public Boolean enable() {
        return TaggedUnionUtils.get(this, Kind.Enable);
    }

    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        if (_value instanceof JsonpSerializable) {
            ((JsonpSerializable) _value).serialize(generator, mapper);
        } else {
            switch (_kind) {
                case Enable:
                    generator.write(((Boolean) this._value));
                    break;
            }
        }
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<KnnQueryRescore> {
        private Kind _kind;
        private Object _value;

        public Builder() {}

        private Builder(KnnQueryRescore o) {
            this._kind = o._kind;
            this._value = o._value;
        }

        public ObjectBuilder<KnnQueryRescore> context(RescoreContext v) {
            this._kind = Kind.Context;
            this._value = v;
            return this;
        }

        public ObjectBuilder<KnnQueryRescore> context(Function<RescoreContext.Builder, ObjectBuilder<RescoreContext>> fn) {
            return this.context(fn.apply(new RescoreContext.Builder()).build());
        }

        public ObjectBuilder<KnnQueryRescore> enable(Boolean v) {
            this._kind = Kind.Enable;
            this._value = v;
            return this;
        }

        @Override
        public KnnQueryRescore build() {
            _checkSingleUse();
            return new KnnQueryRescore(this);
        }
    }

    private static JsonpDeserializer<KnnQueryRescore> buildKnnQueryRescoreDeserializer() {
        return new UnionDeserializer.Builder<KnnQueryRescore, Kind, Object>(KnnQueryRescore::new, false).addMember(
            Kind.Context,
            RescoreContext._DESERIALIZER
        ).addMember(Kind.Enable, JsonpDeserializer.booleanDeserializer()).build();
    }

    public static final JsonpDeserializer<KnnQueryRescore> _DESERIALIZER = JsonpDeserializer.lazy(
        KnnQueryRescore::buildKnnQueryRescoreDeserializer
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this._kind);
        result = 31 * result + Objects.hashCode(this._value);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KnnQueryRescore other = (KnnQueryRescore) o;
        return Objects.equals(this._kind, other._kind) && Objects.equals(this._value, other._value);
    }
}
