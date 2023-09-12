package com.nhnacademy.ticker;

public class Ticker implements Runnable {

    private Thread thread;
    private long nanosec;

    public Ticker(long milliseconds) {
        thread = new Thread(this);
        this.nanosec = milliseconds * 1_000_000;
    }

    public Ticker(String nanoseconds) {
        this(parse(nanoseconds));
    }

    private static long parse(String input) {
        if (!input.endsWith("n")) {
            throw new IllegalArgumentException("");
        }
        return Long.parseLong(input.split("n")[0]);
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    @Override
    public void run() {
        long startAt = System.nanoTime();

        while (!thread.isInterrupted()) {
            startAt += nanosec;
            System.out.println((startAt - System.nanoTime()) / 1_000_000 + " ms");
            try {
                Thread.sleep((startAt - System.nanoTime()) / 1_000_000);
            } catch (InterruptedException ignore) {
                thread.interrupt();
            }
        }
    }
}
