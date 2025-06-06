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

package org.opensearch.client.opensearch.core.search;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: core.search.CompletionSuggester

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class CompletionSuggester extends SuggesterBase
    implements
        FieldSuggesterVariant,
        ToCopyableBuilder<CompletionSuggester.Builder, CompletionSuggester> {

    @Nonnull
    private final Map<String, List<CompletionContext>> contexts;

    @Nullable
    private final SuggestFuzziness fuzzy;

    @Nullable
    private final String regex;

    @Nullable
    private final Boolean skipDuplicates;

    // ---------------------------------------------------------------------------------------------

    private CompletionSuggester(Builder builder) {
        super(builder);
        this.contexts = ApiTypeHelper.unmodifiable(builder.contexts);
        this.fuzzy = builder.fuzzy;
        this.regex = builder.regex;
        this.skipDuplicates = builder.skipDuplicates;
    }

    public static CompletionSuggester of(Function<CompletionSuggester.Builder, ObjectBuilder<CompletionSuggester>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link FieldSuggester} variant kind.
     */
    @Override
    public FieldSuggester.Kind _fieldSuggesterKind() {
        return FieldSuggester.Kind.Completion;
    }

    /**
     * API name: {@code contexts}
     */
    @Nonnull
    public final Map<String, List<CompletionContext>> contexts() {
        return this.contexts;
    }

    /**
     * API name: {@code fuzzy}
     */
    @Nullable
    public final SuggestFuzziness fuzzy() {
        return this.fuzzy;
    }

    /**
     * API name: {@code regex}
     */
    @Nullable
    public final String regex() {
        return this.regex;
    }

    /**
     * API name: {@code skip_duplicates}
     */
    @Nullable
    public final Boolean skipDuplicates() {
        return this.skipDuplicates;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (ApiTypeHelper.isDefined(this.contexts)) {
            generator.writeKey("contexts");
            generator.writeStartObject();
            for (Map.Entry<String, List<CompletionContext>> item0 : this.contexts.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.writeStartArray();
                if (item0.getValue() != null) {
                    for (CompletionContext item1 : item0.getValue()) {
                        item1.serialize(generator, mapper);
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (this.fuzzy != null) {
            generator.writeKey("fuzzy");
            this.fuzzy.serialize(generator, mapper);
        }

        if (this.regex != null) {
            generator.writeKey("regex");
            generator.write(this.regex);
        }

        if (this.skipDuplicates != null) {
            generator.writeKey("skip_duplicates");
            generator.write(this.skipDuplicates);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link CompletionSuggester}.
     */
    public static class Builder extends SuggesterBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, CompletionSuggester> {
        @Nullable
        private Map<String, List<CompletionContext>> contexts;
        @Nullable
        private SuggestFuzziness fuzzy;
        @Nullable
        private String regex;
        @Nullable
        private Boolean skipDuplicates;

        public Builder() {}

        private Builder(CompletionSuggester o) {
            super(o);
            this.contexts = _mapCopy(o.contexts);
            this.fuzzy = o.fuzzy;
            this.regex = o.regex;
            this.skipDuplicates = o.skipDuplicates;
        }

        private Builder(Builder o) {
            super(o);
            this.contexts = _mapCopy(o.contexts);
            this.fuzzy = o.fuzzy;
            this.regex = o.regex;
            this.skipDuplicates = o.skipDuplicates;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * API name: {@code contexts}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>contexts</code>.
         * </p>
         */
        @Nonnull
        public final Builder contexts(Map<String, List<CompletionContext>> map) {
            this.contexts = _mapPutAll(this.contexts, map);
            return this;
        }

        /**
         * API name: {@code contexts}
         *
         * <p>
         * Adds an entry to <code>contexts</code>.
         * </p>
         */
        @Nonnull
        public final Builder contexts(String key, List<CompletionContext> value) {
            this.contexts = _mapPut(this.contexts, key, value);
            return this;
        }

        /**
         * API name: {@code fuzzy}
         */
        @Nonnull
        public final Builder fuzzy(@Nullable SuggestFuzziness value) {
            this.fuzzy = value;
            return this;
        }

        /**
         * API name: {@code fuzzy}
         */
        @Nonnull
        public final Builder fuzzy(Function<SuggestFuzziness.Builder, ObjectBuilder<SuggestFuzziness>> fn) {
            return fuzzy(fn.apply(new SuggestFuzziness.Builder()).build());
        }

        /**
         * API name: {@code regex}
         */
        @Nonnull
        public final Builder regex(@Nullable String value) {
            this.regex = value;
            return this;
        }

        /**
         * API name: {@code skip_duplicates}
         */
        @Nonnull
        public final Builder skipDuplicates(@Nullable Boolean value) {
            this.skipDuplicates = value;
            return this;
        }

        /**
         * Builds a {@link CompletionSuggester}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CompletionSuggester build() {
            _checkSingleUse();

            return new CompletionSuggester(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CompletionSuggester}
     */
    public static final JsonpDeserializer<CompletionSuggester> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CompletionSuggester::setupCompletionSuggesterDeserializer
    );

    protected static void setupCompletionSuggesterDeserializer(ObjectDeserializer<CompletionSuggester.Builder> op) {
        setupSuggesterBaseDeserializer(op);
        op.add(
            Builder::contexts,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(CompletionContext._DESERIALIZER)),
            "contexts"
        );
        op.add(Builder::fuzzy, SuggestFuzziness._DESERIALIZER, "fuzzy");
        op.add(Builder::regex, JsonpDeserializer.stringDeserializer(), "regex");
        op.add(Builder::skipDuplicates, JsonpDeserializer.booleanDeserializer(), "skip_duplicates");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.contexts);
        result = 31 * result + Objects.hashCode(this.fuzzy);
        result = 31 * result + Objects.hashCode(this.regex);
        result = 31 * result + Objects.hashCode(this.skipDuplicates);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CompletionSuggester other = (CompletionSuggester) o;
        return Objects.equals(this.contexts, other.contexts)
            && Objects.equals(this.fuzzy, other.fuzzy)
            && Objects.equals(this.regex, other.regex)
            && Objects.equals(this.skipDuplicates, other.skipDuplicates);
    }
}
