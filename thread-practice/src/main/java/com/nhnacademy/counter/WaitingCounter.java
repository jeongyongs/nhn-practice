package com.nhnacademy.counter;

public class WaitingCounter implements Runnable {

    private Thread thread;
    private ThreadInCounter counter;

    public WaitingCounter(ThreadInCounter counter) {
        thread = new Thread(this);
        this.counter = counter;
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        try {
            counter.getThread().join();
            System.out.println("Waiting done.");
        } catch (InterruptedException ignore) {
            thread.interrupt();
        }
    }

    public Thread getThread() {
        return thread;
    }

    public boolean isAlive() {
        return thread.isAlive();
    }
}
