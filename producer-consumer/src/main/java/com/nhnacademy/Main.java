package com.nhnacademy;

public class Main {

    public static void main(String[] args) {
        Resource resource = new Resource(5);
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        producer.start();
        consumer.start();
    }
}
