package com.nhnacademy.counter;

/**
 * 쓰레드 연습을 위한 Runnable 카운터 클래스입니다.
 */
public class RunnableCounter implements Runnable {

    private static final int DEFAULT_MAX_COUNT = 10;

    private int maxCount;
    private int count;

    /**
     * maxCount만큼 실행하는 카운터를 생성합니다.
     * 
     * @param maxCount 최대 실행 횟수입니다.
     */
    public RunnableCounter(int maxCount) {
        this.maxCount = maxCount;
        count = 0;
    }

    /**
     * 최대 10회 카운터를 실행합니다.
     */
    public RunnableCounter() {
        this(DEFAULT_MAX_COUNT);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            process();
        }
    }

    private void process() {
        if (count >= maxCount) {
            Thread.currentThread().interrupt();
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.printf("%s : %d%n", Thread.currentThread().getName(), ++count);
    }
}
