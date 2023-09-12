package com.nhnacademy.exam;

import java.lang.reflect.Field;
import com.nhnacademy.counter.ThreadInCounter;

public class Exam02 {

    @SuppressWarnings("all")
    public static void main(String[] args) throws NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException, InterruptedException {
        ThreadInCounter threadInCounter = new ThreadInCounter();

        threadInCounter.start();

        Field field = threadInCounter.getClass().getDeclaredField("thread");
        field.setAccessible(true);
        Thread thread = (Thread) field.get(threadInCounter);

        while (true) {
            System.out.println(thread.getState());
            Thread.sleep(1000);
        }
    }
}
