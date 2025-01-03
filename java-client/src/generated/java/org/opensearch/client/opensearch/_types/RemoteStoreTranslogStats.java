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

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.RemoteStoreTranslogStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RemoteStoreTranslogStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RemoteStoreTranslogStats.Builder, RemoteStoreTranslogStats> {

    @Nonnull
    private final RemoteStoreTranslogUploadStats upload;

    // ---------------------------------------------------------------------------------------------

    private RemoteStoreTranslogStats(Builder builder) {
        this.upload = ApiTypeHelper.requireNonNull(builder.upload, this, "upload");
    }

    public static RemoteStoreTranslogStats of(Function<RemoteStoreTranslogStats.Builder, ObjectBuilder<RemoteStoreTranslogStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code upload}
     */
    @Nonnull
    public final RemoteStoreTranslogUploadStats upload() {
        return this.upload;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeKey("upload");
        this.upload.serialize(generator, mapper);
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
     * Builder for {@link RemoteStoreTranslogStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RemoteStoreTranslogStats> {
        private RemoteStoreTranslogUploadStats upload;

        public Builder() {}

        private Builder(RemoteStoreTranslogStats o) {
            this.upload = o.upload;
        }

        private Builder(Builder o) {
            this.upload = o.upload;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code upload}
         */
        @Nonnull
        public final Builder upload(RemoteStoreTranslogUploadStats value) {
            this.upload = value;
            return this;
        }

        /**
         * Required - API name: {@code upload}
         */
        @Nonnull
        public final Builder upload(Function<RemoteStoreTranslogUploadStats.Builder, ObjectBuilder<RemoteStoreTranslogUploadStats>> fn) {
            return upload(fn.apply(new RemoteStoreTranslogUploadStats.Builder()).build());
        }

        /**
         * Builds a {@link RemoteStoreTranslogStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RemoteStoreTranslogStats build() {
            _checkSingleUse();

            return new RemoteStoreTranslogStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RemoteStoreTranslogStats}
     */
    public static final JsonpDeserializer<RemoteStoreTranslogStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RemoteStoreTranslogStats::setupRemoteStoreTranslogStatsDeserializer
    );

    protected static void setupRemoteStoreTranslogStatsDeserializer(ObjectDeserializer<RemoteStoreTranslogStats.Builder> op) {
        op.add(Builder::upload, RemoteStoreTranslogUploadStats._DESERIALIZER, "upload");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.upload.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RemoteStoreTranslogStats other = (RemoteStoreTranslogStats) o;
        return this.upload.equals(other.upload);
    }
}