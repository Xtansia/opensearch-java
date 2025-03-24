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

package org.opensearch.client.opensearch.snapshot;

import jakarta.json.stream.JsonGenerator;
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
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: snapshot.SnapshotShardsStatsSummaryItem

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SnapshotShardsStatsSummaryItem
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SnapshotShardsStatsSummaryItem.Builder, SnapshotShardsStatsSummaryItem> {

    @Nullable
    private final Long fileCount;

    @Nullable
    private final Long sizeInBytes;

    // ---------------------------------------------------------------------------------------------

    private SnapshotShardsStatsSummaryItem(Builder builder) {
        this.fileCount = builder.fileCount;
        this.sizeInBytes = builder.sizeInBytes;
    }

    public static SnapshotShardsStatsSummaryItem of(
        Function<SnapshotShardsStatsSummaryItem.Builder, ObjectBuilder<SnapshotShardsStatsSummaryItem>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The number of files in the shard snapshot.
     * <p>
     * API name: {@code file_count}
     * </p>
     */
    @Nullable
    public final Long fileCount() {
        return this.fileCount;
    }

    /**
     * The total size of files in the shard snapshot.
     * <p>
     * API name: {@code size_in_bytes}
     * </p>
     */
    @Nullable
    public final Long sizeInBytes() {
        return this.sizeInBytes;
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
        if (this.fileCount != null) {
            generator.writeKey("file_count");
            generator.write(this.fileCount);
        }

        if (this.sizeInBytes != null) {
            generator.writeKey("size_in_bytes");
            generator.write(this.sizeInBytes);
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
     * Builder for {@link SnapshotShardsStatsSummaryItem}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SnapshotShardsStatsSummaryItem> {
        @Nullable
        private Long fileCount;
        @Nullable
        private Long sizeInBytes;

        public Builder() {}

        private Builder(SnapshotShardsStatsSummaryItem o) {
            this.fileCount = o.fileCount;
            this.sizeInBytes = o.sizeInBytes;
        }

        private Builder(Builder o) {
            this.fileCount = o.fileCount;
            this.sizeInBytes = o.sizeInBytes;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The number of files in the shard snapshot.
         * <p>
         * API name: {@code file_count}
         * </p>
         */
        @Nonnull
        public final Builder fileCount(@Nullable Long value) {
            this.fileCount = value;
            return this;
        }

        /**
         * The total size of files in the shard snapshot.
         * <p>
         * API name: {@code size_in_bytes}
         * </p>
         */
        @Nonnull
        public final Builder sizeInBytes(@Nullable Long value) {
            this.sizeInBytes = value;
            return this;
        }

        /**
         * Builds a {@link SnapshotShardsStatsSummaryItem}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SnapshotShardsStatsSummaryItem build() {
            _checkSingleUse();

            return new SnapshotShardsStatsSummaryItem(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SnapshotShardsStatsSummaryItem}
     */
    public static final JsonpDeserializer<SnapshotShardsStatsSummaryItem> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SnapshotShardsStatsSummaryItem::setupSnapshotShardsStatsSummaryItemDeserializer
    );

    protected static void setupSnapshotShardsStatsSummaryItemDeserializer(ObjectDeserializer<SnapshotShardsStatsSummaryItem.Builder> op) {
        op.add(Builder::fileCount, JsonpDeserializer.longDeserializer(), "file_count");
        op.add(Builder::sizeInBytes, JsonpDeserializer.longDeserializer(), "size_in_bytes");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.fileCount);
        result = 31 * result + Objects.hashCode(this.sizeInBytes);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SnapshotShardsStatsSummaryItem other = (SnapshotShardsStatsSummaryItem) o;
        return Objects.equals(this.fileCount, other.fileCount) && Objects.equals(this.sizeInBytes, other.sizeInBytes);
    }
}
