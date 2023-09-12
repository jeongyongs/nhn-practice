package com.nhnacademy.daemon;

import com.nhnacademy.counter.ThreadInCounter;

public class Daemon {

    public static void main(String[] args) {
        ThreadInCounter counter1 = new ThreadInCounter();
        ThreadInCounter counter2 = new ThreadInCounter(5);
        ThreadInCounter counter3 = new ThreadInCounter(7);

        counter1.setDaemon(true);
        counter3.setDaemon(true);

        counter1.start();
        counter2.start();
        counter3.start();
    }
}
