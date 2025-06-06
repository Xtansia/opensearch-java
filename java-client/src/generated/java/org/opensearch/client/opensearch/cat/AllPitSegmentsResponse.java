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

package org.opensearch.client.opensearch.cat;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch.cat.segments.SegmentsRecord;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: cat.all_pit_segments.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AllPitSegmentsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<AllPitSegmentsResponse.Builder, AllPitSegmentsResponse> {

    @Nonnull
    private final List<SegmentsRecord> valueBody;

    // ---------------------------------------------------------------------------------------------

    private AllPitSegmentsResponse(Builder builder) {
        this.valueBody = ApiTypeHelper.unmodifiableRequired(builder.valueBody, this, "valueBody");
    }

    public static AllPitSegmentsResponse of(Function<AllPitSegmentsResponse.Builder, ObjectBuilder<AllPitSegmentsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Response value.
     */
    @Nonnull
    public final List<SegmentsRecord> valueBody() {
        return this.valueBody;
    }

    /**
     * Serialize this value to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartArray();
        for (SegmentsRecord item0 : this.valueBody) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link AllPitSegmentsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, AllPitSegmentsResponse> {
        private List<SegmentsRecord> valueBody;

        public Builder() {}

        private Builder(AllPitSegmentsResponse o) {
            this.valueBody = _listCopy(o.valueBody);
        }

        private Builder(Builder o) {
            this.valueBody = _listCopy(o.valueBody);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Response value.
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>valueBody</code>.
         * </p>
         */
        @Nonnull
        public final Builder valueBody(List<SegmentsRecord> list) {
            this.valueBody = _listAddAll(this.valueBody, list);
            return this;
        }

        /**
         * Required - Response value.
         *
         * <p>
         * Adds one or more values to <code>valueBody</code>.
         * </p>
         */
        @Nonnull
        public final Builder valueBody(SegmentsRecord value, SegmentsRecord... values) {
            this.valueBody = _listAdd(this.valueBody, value, values);
            return this;
        }

        /**
         * Required - Response value.
         *
         * <p>
         * Adds a value to <code>valueBody</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder valueBody(Function<SegmentsRecord.Builder, ObjectBuilder<SegmentsRecord>> fn) {
            return valueBody(fn.apply(new SegmentsRecord.Builder()).build());
        }

        /**
         * Builds a {@link AllPitSegmentsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public AllPitSegmentsResponse build() {
            _checkSingleUse();

            return new AllPitSegmentsResponse(this);
        }
    }

    public static final JsonpDeserializer<AllPitSegmentsResponse> _DESERIALIZER = createAllPitSegmentsResponseDeserializer();

    protected static JsonpDeserializer<AllPitSegmentsResponse> createAllPitSegmentsResponseDeserializer() {
        JsonpDeserializer<List<SegmentsRecord>> valueDeserializer = JsonpDeserializer.arrayDeserializer(SegmentsRecord._DESERIALIZER);

        return JsonpDeserializer.of(
            valueDeserializer.acceptedEvents(),
            (parser, mapper) -> new Builder().valueBody(valueDeserializer.deserialize(parser, mapper)).build()
        );
    }
}
