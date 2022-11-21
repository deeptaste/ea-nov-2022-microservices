package edu.miu.service;

public interface HelloConsumer {
    void bindToHelloQueue(String payload);
}
