package com.haiphamcoder.readwritekafka.config.properties;

import lombok.Data;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;

@Data
public class KafkaProducerProperties {
    private String bootstrapServers;
    private String acks;
    private Integer retries;
    private Integer batchSize;
    private Integer lingerMs;
    private Integer bufferMemory;
    private Integer maxRequestSize;
    private String keySerializer = StringSerializer.class.getName();
    private String valueSerializer = ByteArraySerializer.class.getName();
}
