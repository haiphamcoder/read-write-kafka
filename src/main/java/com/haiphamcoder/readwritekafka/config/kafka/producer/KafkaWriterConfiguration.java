package com.haiphamcoder.readwritekafka.config.kafka.producer;

import com.haiphamcoder.readwritekafka.config.properties.KafkaProducerProperties;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaWriterConfiguration {
    @Bean("kafkaProducerProperties")
    @ConfigurationProperties(prefix = "kafka.test.producer")
    public KafkaProducerProperties kafkaProducerProperties() {
        return new KafkaProducerProperties();
    }

    @Bean("kafkaBrokerWriterProperties")
    public Properties kafkaBrokerWriterProperties() {
        final Properties properties = new Properties();
        KafkaProducerProperties producerProperties = kafkaProducerProperties();

        // Set properties for Kafka producer
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, producerProperties.getBootstrapServers());
        properties.put(ProducerConfig.ACKS_CONFIG, producerProperties.getAcks());
        properties.put(ProducerConfig.RETRIES_CONFIG, producerProperties.getRetries());
        properties.put(ProducerConfig.LINGER_MS_CONFIG, producerProperties.getLingerMs());
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, producerProperties.getBatchSize());
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, producerProperties.getBufferMemory());
        properties.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, producerProperties.getMaxRequestSize());
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, producerProperties.getKeySerializer());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, producerProperties.getValueSerializer());

        return properties;
    }
}
