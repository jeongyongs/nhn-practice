package com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 소비자 클래스입니다.
 */
public class Consumer implements Runnable {

    private static final int MIN_DELAY = 1_000;
    private static final int MAX_DELAY = 10_000;

    private static int count = 0;

    private int consumerId;
    private Thread thread;
    private Resource resource;

    /**
     * 소비자를 생성합니다.
     * 
     * @param resource 관리할 자원입니다.
     */
    public Consumer(Resource resource) {
        consumerId = ++count;
        thread = new Thread(this, "consumer" + consumerId);
        this.resource = resource;
    }

    /**
     * 소비자를 실행합니다.
     */
    public void start() {
        thread.start();
    }

    /**
     * 소비자에게 종료 요청을 보냅니다.
     */
    public void stop() {
        thread.interrupt();
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            proccess();
            sleep();
        }
    }

    private void proccess() {
        try {
            resource.get();
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
