package com.nhnacademy.threadpool;

public class Worker implements Runnable {

    private static final String DEFAULT = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";

    private Thread thread;
    private String name;

    public Worker(String name) {
        thread = new Thread(this);
        this.name = name;
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(GREEN + name + " start!" + DEFAULT);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
            thread.interrupt();
        }
        System.out.println(RED + name + " stop!" + DEFAULT);
    }
}
