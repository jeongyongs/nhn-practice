package com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {

    private static int consumerCount = 0;

    public static void main(String[] args) {
        // 공용 자원 생성
        Store resource = new Store(10, 5);
        // 생산자 생성
        Producer producer = new Producer(resource);
        producer.start();
        // 콘솔 출력기 생성
        Thread info = new Thread(() -> showInfo(resource));
        info.start();
        // 소비자 생성
        IntStream.range(0, 50).forEach(ignore -> createConsumer(resource));
    }

    private static void createConsumer(Store resource) {
        new Consumer(resource).visit();
        consumerCount++;
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(1_000, 5_000)); // 손님이 매장을 방문하는 간격
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
    }

    private static void showInfo(Store resource) {
        while (!Thread.interrupted()) {
            clear();
            System.out.println("┌────────────────────┐");
            String result = String.format("│ %-7s : %3d │%n%s", "총 소비자 수", consumerCount,
                    resource.getInfo());
            System.out.print(result);
            System.out.println("└────────────────────┘");
            sleep();
        }
    }

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
    }
}
