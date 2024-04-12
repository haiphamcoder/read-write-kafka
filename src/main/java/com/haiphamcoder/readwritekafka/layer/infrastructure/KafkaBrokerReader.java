package com.haiphamcoder.readwritekafka.layer.infrastructure;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

public class KafkaBrokerReader {
    private Collection<String> topics;
    private Properties consumerProperties;

    private boolean status = false;
    public KafkaBrokerReader() {
    }

    public KafkaBrokerReader(Properties consumerProperties, Collection<String> topics){
        this.consumerProperties = consumerProperties;
        this.topics = topics;
    }

    public void start(){
        status = true;
        while(status){
            try{
                KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<>(consumerProperties);
                consumer.subscribe(topics);

                ConsumerRecords<String, byte[]> records = consumer.poll(Duration.ofMillis(100));
                records.forEach(record -> {
                    System.out.println("Record: " + Arrays.toString(record.value()));
                });
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void stop(){
        status = false;
    }
}
