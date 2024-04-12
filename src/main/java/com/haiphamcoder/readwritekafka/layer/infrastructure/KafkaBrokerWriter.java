package com.haiphamcoder.readwritekafka.layer.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

@Slf4j
public class KafkaBrokerWriter {
    private final Producer<String, byte[]> producer;
    private final String topic;

    public KafkaBrokerWriter(Properties producerProperties, String topicName) {
        this.producer = new KafkaProducer<String, byte[]>(producerProperties);
        this.topic = topicName;
    }

    public void write(String message) {
        log.info("Writing message: {}", message);
        producer.send(new ProducerRecord<>(topic, message.getBytes()));
    }

    public void write(String message, Integer partition) {
        log.info("Writing message: {}", message);
        producer.send(new ProducerRecord<>(topic, partition, null, message.getBytes()));
    }

    public void close() {
        log.info("Closing producer");
        producer.close();
    }
}
