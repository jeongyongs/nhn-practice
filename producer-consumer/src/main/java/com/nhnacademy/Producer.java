package com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 생산자 클래스입니다.
 */
public class Producer implements Runnable {

    private static final int MAX_DELAY = 10_000;
    private static final int MIN_DELAY = 1_000;

    private Thread thread;
    private Store store;

    /**
     * 생산자를 생성합니다.
     * 
     * @param store 납품할 매장입니다.
     */
    public Producer(Store store) {
        thread = new Thread(this, "producer");
        this.store = store;
    }

    /**
     * 생산자를 실행합니다.
     */
    public void start() {
        thread.start();
    }

    /**
     * 생산자에게 종료 요청을 보냅니다.
     */
    public void stop() {
        thread.interrupt();
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            sleep(); // 재고를 채우는데 걸리는 시간
            proccess();
        }
    }

    private void proccess() {
        try {
            store.add();
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(MIN_DELAY, MAX_DELAY));
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
    }
}
