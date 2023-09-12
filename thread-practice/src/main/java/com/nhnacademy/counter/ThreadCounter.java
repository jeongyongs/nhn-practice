package com.nhnacademy.counter;

/**
 * 쓰레드 연습을 위한 쓰레드 카운터 클래스입니다.
 */
public class ThreadCounter extends Thread {

    private static final int DEFAULT_MAX_COUNT = 10;

    private int maxCount;
    private int count;

    /**
     * maxCount만큼 실행하는 카운터를 생성합니다.
     * 
     * @param maxCount 최대 실행 횟수입니다.
     */
    public ThreadCounter(String name, int maxCount) {
        super(name);
        this.maxCount = maxCount;
        count = 0;
    }

    /**
     * 최대 10회 카운터를 실행합니다.
     */
    public ThreadCounter(String name) {
        this(name, DEFAULT_MAX_COUNT);
    }

    @Override
    public void run() {
        while (!interrupted()) {
            process();
        }
    }

    private void process() {
        if (count >= maxCount) {
            interrupt();
            return;
        }
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            interrupt();
        }
        System.out.printf("%s : %d%n", getName(), ++count);
    }
}
