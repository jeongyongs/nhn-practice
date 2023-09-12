package com.nhnacademy.counter;

/**
 * 쓰레드 연습을 위한 Runnable 카운터 클래스입니다.
 */
public class ThreadInCounter implements Runnable {

    private static final int DEFAULT_MAX_COUNT = 10;

    private int maxCount;
    private int count;
    private Thread thread;

    /**
     * maxCount만큼 실행하는 카운터를 생성합니다.
     * 
     * @param maxCount 최대 실행 횟수입니다.
     */
    public ThreadInCounter(int maxCount) {
        this.maxCount = maxCount;
        count = 0;
        thread = new Thread(this);
    }

    /**
     * 최대 10회 카운터를 실행합니다.
     */
    public ThreadInCounter() {
        this(DEFAULT_MAX_COUNT);
    }

    /**
     * 카운터 쓰레드를 시작합니다.
     */
    public void start() {
        thread.start();
    }

    /**
     * 카운터 쓰레드를 종료합니다.
     */
    public void stop() {
        thread.interrupt();
    }

    @Override
    public void run() {
        try {
            process();
        } catch (InterruptedException ignore) {
            thread.interrupt();
        }
    }

    private void process() throws InterruptedException {
        while (count < maxCount) {
            Thread.sleep(10000);
            System.out.printf("%s : %d%n", Thread.currentThread().getName(), ++count);
        }
    }
}
