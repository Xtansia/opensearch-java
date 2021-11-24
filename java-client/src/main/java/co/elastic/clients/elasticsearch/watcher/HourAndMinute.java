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

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package co.elastic.clients.elasticsearch.watcher;

import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ModelTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import co.elastic.clients.util.ObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.Integer;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import javax.annotation.Nullable;

// typedef: watcher._types.HourAndMinute
@JsonpDeserializable
public class HourAndMinute implements JsonpSerializable {
	private final List<Integer> hour;

	private final List<Integer> minute;

	// ---------------------------------------------------------------------------------------------

	private HourAndMinute(Builder builder) {

		this.hour = ModelTypeHelper.unmodifiableRequired(builder.hour, this, "hour");
		this.minute = ModelTypeHelper.unmodifiableRequired(builder.minute, this, "minute");

	}

	public static HourAndMinute of(Consumer<Builder> fn) {
		Builder builder = new Builder();
		fn.accept(builder);
		return builder.build();
	}

	/**
	 * Required - API name: {@code hour}
	 */
	public final List<Integer> hour() {
		return this.hour;
	}

	/**
	 * Required - API name: {@code minute}
	 */
	public final List<Integer> minute() {
		return this.minute;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		serializeInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		if (ModelTypeHelper.isDefined(this.hour)) {
			generator.writeKey("hour");
			generator.writeStartArray();
			for (Integer item0 : this.hour) {
				generator.write(item0);

			}
			generator.writeEnd();

		}
		if (ModelTypeHelper.isDefined(this.minute)) {
			generator.writeKey("minute");
			generator.writeStartArray();
			for (Integer item0 : this.minute) {
				generator.write(item0);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link HourAndMinute}.
	 */
	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<HourAndMinute> {
		private List<Integer> hour;

		private List<Integer> minute;

		/**
		 * Required - API name: {@code hour}
		 */
		public final Builder hour(List<Integer> value) {
			this.hour = value;
			return this;
		}

		/**
		 * Required - API name: {@code hour}
		 */
		public final Builder hour(Integer... value) {
			this.hour = Arrays.asList(value);
			return this;
		}

		/**
		 * Required - API name: {@code minute}
		 */
		public final Builder minute(List<Integer> value) {
			this.minute = value;
			return this;
		}

		/**
		 * Required - API name: {@code minute}
		 */
		public final Builder minute(Integer... value) {
			this.minute = Arrays.asList(value);
			return this;
		}

		/**
		 * Builds a {@link HourAndMinute}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public HourAndMinute build() {
			_checkSingleUse();

			return new HourAndMinute(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link HourAndMinute}
	 */
	public static final JsonpDeserializer<HourAndMinute> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			HourAndMinute::setupHourAndMinuteDeserializer);

	protected static void setupHourAndMinuteDeserializer(ObjectDeserializer<HourAndMinute.Builder> op) {

		op.add(Builder::hour, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.integerDeserializer()), "hour");
		op.add(Builder::minute, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.integerDeserializer()), "minute");

	}

}