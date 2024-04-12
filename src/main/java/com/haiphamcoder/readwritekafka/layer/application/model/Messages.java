package com.haiphamcoder.readwritekafka.layer.application.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Messages implements Iterable<Message> {
    private final List<Message> queue;

    public Messages(List<Message> messages) {
        this.queue = messages;
    }

    public Messages() {
        this(new LinkedList<>());
    }

    public void add(Message message) {
        this.queue.add(message);
    }

    public void clear() {
        this.queue.clear();
    }

    public Message first() {
        return queue.get(0);
    }

    public Message last() {
        return queue.get(queue.size() - 1);
    }

    public int size() {
        return queue.size();
    }

    @Override
    public Iterator<Message> iterator() {
        return this.queue.iterator();
    }

    @Override
    public void forEach(Consumer<? super Message> action) {
        this.queue.forEach(action);
    }

    @Override
    public Spliterator<Message> spliterator() {
        return this.queue.spliterator();
    }

    public Stream<Message> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }
}
