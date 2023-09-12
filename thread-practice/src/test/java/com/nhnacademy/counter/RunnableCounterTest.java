package com.nhnacademy.counter;

public class RunnableCounterTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableCounter(5), "테스트1");
        Thread thread2 = new Thread(new RunnableCounter(5), "테스트2");

        thread1.start();
        thread2.start();
    }
}
