package com.haiphamcoder.readwritekafka.config.properties;

import lombok.Data;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

@Data
public class KafkaConsumerProperties {
    private String bootstrapServers;
    private String groupId;
    private String enableAutoCommit;
    private String autoOffsetReset;
    private Integer maxPollRecords;
    private String keyDeserializer = StringDeserializer.class.getName();
    private String valueDeserializer = ByteArrayDeserializer.class.getName();
}
