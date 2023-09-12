package com.nhnacademy.counter;

@SuppressWarnings("all")
public class ThreadCounterTest {

    public static void main(String[] args) {
        ThreadCounter threadCounter1 = new ThreadCounter("테스트1", 3);
        ThreadCounter threadCounter2 = new ThreadCounter("테스트2", 3);

        threadCounter1.start();
        threadCounter2.start();
    }
}
