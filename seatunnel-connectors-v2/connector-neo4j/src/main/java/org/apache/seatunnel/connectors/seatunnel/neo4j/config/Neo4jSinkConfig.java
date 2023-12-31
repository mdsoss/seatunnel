/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.seatunnel.connectors.seatunnel.neo4j.config;

import org.apache.seatunnel.api.configuration.Option;
import org.apache.seatunnel.api.configuration.Options;
import org.apache.seatunnel.connectors.seatunnel.neo4j.constants.SinkWriteMode;

import java.util.Map;

public class Neo4jSinkConfig extends Neo4jCommonConfig {
    public static final Option<Map<String, String>> QUERY_PARAM_POSITION =
            Options.key("queryParamPosition")
                    .mapType()
                    .noDefaultValue()
                    .withDescription(
                            "position mapping information for query parameters. key name is parameter placeholder name. associated value is position of field in input data row.");

    public static final Option<Integer> MAX_BATCH_SIZE =
            Options.key("max_batch_size")
                    .intType()
                    .defaultValue(500)
                    .withDescription("neo4j write max batch size");
    public static final Option<SinkWriteMode> WRITE_MODE =
            Options.key("write_mode")
                    .enumType(SinkWriteMode.class)
                    .defaultValue(SinkWriteMode.ONE_BY_ONE)
                    .withDescription(
                            "The write mode on the sink end is oneByOne by default in order to maintain compatibility with previous code.");
}
