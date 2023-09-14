package com.nhnacademy;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        // 공용 자원 생성
        Resource resource = new Resource(10, 5);
        // 생산자 생성
        Producer producer = new Producer(resource);
        producer.start();
        // 소비자 생성
        IntStream.range(0, 10).forEach(ignore -> new Consumer(resource).visit());
    }
}
