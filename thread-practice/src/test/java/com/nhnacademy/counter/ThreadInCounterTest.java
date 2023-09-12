package com.nhnacademy.counter;

@SuppressWarnings("all")
public class ThreadInCounterTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadInCounter threadInCounter = new ThreadInCounter();

        threadInCounter.start();
        Thread.sleep(1000);
        threadInCounter.stop();
    }
}
