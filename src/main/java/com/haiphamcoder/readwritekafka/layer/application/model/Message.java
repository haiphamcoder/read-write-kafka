package com.haiphamcoder.readwritekafka.layer.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private final byte[] data;
    private final long timestamp;
    private final String topic;
}
