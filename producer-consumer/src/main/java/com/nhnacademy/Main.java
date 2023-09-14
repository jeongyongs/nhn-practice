package com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        // 공용 자원 생성
        Store resource = new Store(10, 5);
        // 생산자 생성
        Producer producer = new Producer(resource);
        producer.start();
        // 소비자 생성
        IntStream.range(0, 50).forEach(ignore -> createConsumer(resource));
    }

    private static void createConsumer(Store resource) {
        new Consumer(resource).visit();
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(1_000, 5_000)); // 손님이 매장을 방문하는 간격
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
    }
}
