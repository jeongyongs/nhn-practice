package com.nhnacademy.exam;

import com.nhnacademy.counter.ThreadInCounter;
import com.nhnacademy.counter.WaitingCounter;

public class Exam04 {

    public static void main(String[] args) throws InterruptedException {
        ThreadInCounter counter = new ThreadInCounter(3);
        WaitingCounter waiting = new WaitingCounter(counter);

        counter.start();
        waiting.start();

        while (waiting.isAlive()) {
            System.out.println("\n".repeat(10));
            System.out.println("thread1 : " + counter.getThread().getState());
            System.out.println("thread2 : " + waiting.getThread().getState());
            Thread.sleep(1);
        }
        System.out.println("\n".repeat(10));
        System.out.println("thread1 : " + counter.getThread().getState());
        System.out.println("thread2 : " + waiting.getThread().getState());
    }
}
