/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

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

// typedef: ml.ModelStats

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ModelStats implements PlainJsonSerializable, ToCopyableBuilder<ModelStats.Builder, ModelStats> {

    @Nullable
    private final Long mlActionFailureCount;

    @Nullable
    private final Long mlActionRequestCount;

    @Nullable
    private final Long mlExecutingTaskCount;

    // ---------------------------------------------------------------------------------------------

    private ModelStats(Builder builder) {
        this.mlActionFailureCount = builder.mlActionFailureCount;
        this.mlActionRequestCount = builder.mlActionRequestCount;
        this.mlExecutingTaskCount = builder.mlExecutingTaskCount;
    }

    public static ModelStats of(Function<ModelStats.Builder, ObjectBuilder<ModelStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The failure count.
     * <p>
     * API name: {@code ml_action_failure_count}
     * </p>
     */
    @Nullable
    public final Long mlActionFailureCount() {
        return this.mlActionFailureCount;
    }

    /**
     * The request count.
     * <p>
     * API name: {@code ml_action_request_count}
     * </p>
     */
    @Nullable
    public final Long mlActionRequestCount() {
        return this.mlActionRequestCount;
    }

    /**
     * The executing task count.
     * <p>
     * API name: {@code ml_executing_task_count}
     * </p>
     */
    @Nullable
    public final Long mlExecutingTaskCount() {
        return this.mlExecutingTaskCount;
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
        if (this.mlActionFailureCount != null) {
            generator.writeKey("ml_action_failure_count");
            generator.write(this.mlActionFailureCount);
        }

        if (this.mlActionRequestCount != null) {
            generator.writeKey("ml_action_request_count");
            generator.write(this.mlActionRequestCount);
        }

        if (this.mlExecutingTaskCount != null) {
            generator.writeKey("ml_executing_task_count");
            generator.write(this.mlExecutingTaskCount);
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
     * Builder for {@link ModelStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ModelStats> {
        @Nullable
        private Long mlActionFailureCount;
        @Nullable
        private Long mlActionRequestCount;
        @Nullable
        private Long mlExecutingTaskCount;

        public Builder() {}

        private Builder(ModelStats o) {
            this.mlActionFailureCount = o.mlActionFailureCount;
            this.mlActionRequestCount = o.mlActionRequestCount;
            this.mlExecutingTaskCount = o.mlExecutingTaskCount;
        }

        private Builder(Builder o) {
            this.mlActionFailureCount = o.mlActionFailureCount;
            this.mlActionRequestCount = o.mlActionRequestCount;
            this.mlExecutingTaskCount = o.mlExecutingTaskCount;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The failure count.
         * <p>
         * API name: {@code ml_action_failure_count}
         * </p>
         */
        @Nonnull
        public final Builder mlActionFailureCount(@Nullable Long value) {
            this.mlActionFailureCount = value;
            return this;
        }

        /**
         * The request count.
         * <p>
         * API name: {@code ml_action_request_count}
         * </p>
         */
        @Nonnull
        public final Builder mlActionRequestCount(@Nullable Long value) {
            this.mlActionRequestCount = value;
            return this;
        }

        /**
         * The executing task count.
         * <p>
         * API name: {@code ml_executing_task_count}
         * </p>
         */
        @Nonnull
        public final Builder mlExecutingTaskCount(@Nullable Long value) {
            this.mlExecutingTaskCount = value;
            return this;
        }

        /**
         * Builds a {@link ModelStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ModelStats build() {
            _checkSingleUse();

            return new ModelStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ModelStats}
     */
    public static final JsonpDeserializer<ModelStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ModelStats::setupModelStatsDeserializer
    );

    protected static void setupModelStatsDeserializer(ObjectDeserializer<ModelStats.Builder> op) {
        op.add(Builder::mlActionFailureCount, JsonpDeserializer.longDeserializer(), "ml_action_failure_count");
        op.add(Builder::mlActionRequestCount, JsonpDeserializer.longDeserializer(), "ml_action_request_count");
        op.add(Builder::mlExecutingTaskCount, JsonpDeserializer.longDeserializer(), "ml_executing_task_count");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.mlActionFailureCount);
        result = 31 * result + Objects.hashCode(this.mlActionRequestCount);
        result = 31 * result + Objects.hashCode(this.mlExecutingTaskCount);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ModelStats other = (ModelStats) o;
        return Objects.equals(this.mlActionFailureCount, other.mlActionFailureCount)
            && Objects.equals(this.mlActionRequestCount, other.mlActionRequestCount)
            && Objects.equals(this.mlExecutingTaskCount, other.mlExecutingTaskCount);
    }
}
