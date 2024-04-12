package com.haiphamcoder.readwritekafka.config.kafka.consumer;

import com.haiphamcoder.readwritekafka.config.properties.KafkaConsumerProperties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaReaderConfiguration {
    @Bean("kafkaConsumerProperties")
    @ConfigurationProperties(prefix = "kafka.test.consumer")
    public KafkaConsumerProperties kafkaConsumerProperties() {
        return new KafkaConsumerProperties();
    }

    @Bean("kafkaBrokerReaderProperties")
    public Properties kafkaBrokerReaderProperties() {
        final Properties properties = new Properties();
        KafkaConsumerProperties consumerProperties = kafkaConsumerProperties();

        // Set properties for Kafka consumer
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, consumerProperties.getBootstrapServers());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, consumerProperties.getGroupId());
        properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, consumerProperties.getMaxPollRecords());
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, consumerProperties.getEnableAutoCommit());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, consumerProperties.getAutoOffsetReset());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, consumerProperties.getKeyDeserializer());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, consumerProperties.getValueDeserializer());

        return properties;
    }
}
