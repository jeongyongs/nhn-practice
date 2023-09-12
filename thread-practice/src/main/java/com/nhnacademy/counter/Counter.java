package com.nhnacademy.counter;

/**
 * 쓰레드 연습을 위한 카운터 클래스입니다.
 */
public class Counter {

    private static final int DEFAULT_MAX_COUNT = 10;

    private int maxCount;
    private int count;
    private String name;

    /**
     * maxCount만큼 실행하는 카운터를 생성합니다.
     * 
     * @param maxCount 최대 실행 횟수입니다.
     */
    public Counter(String name, int maxCount) {
        this.maxCount = maxCount;
        count = 0;
        this.name = name;
    }

    /**
     * 최대 10회 카운터를 실행합니다.
     */
    public Counter(String name) {
        this(name, DEFAULT_MAX_COUNT);
    }

    /**
     * 카운터를 실행합니다.
     * 
     * @throws InterruptedException 인터럽트가 발생했을 경우
     */
    public void run() throws InterruptedException {
        while (count < maxCount) {
            Thread.sleep(1000);
            System.out.printf("%s : %d%n", name, ++count);
        }
    }
}
