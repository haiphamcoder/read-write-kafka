package com.haiphamcoder.readwritekafka;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReadWriteKafkaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        System.out.println(StringDeserializer.class.getName());
    }

}
