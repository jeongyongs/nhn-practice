package com.nhnacademy.counter;

public class SharedCounter implements Runnable {

    private static final int DEFAULT_MAX_COUNT = 100000;
    private Thread thread;
    private int count;
    private int maxCount;
    private Count sharedCount;

    public SharedCounter(int maxCount, Count sharedCount) {
        thread = new Thread(this, "SharedCounter");
        count = 0;
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
    }

    public SharedCounter(Count sharedCount) {
        this(DEFAULT_MAX_COUNT, sharedCount);
    }

    public int getCount() {
        return count;
    }

    public void stop() {
        thread.interrupt();
    }

    public void start() {
        thread.start();
    }

    public boolean isAlive() {
        return thread.isAlive();
    }

    @Override
    public void run() {
        while (!thread.isInterrupted() && count < maxCount) {
            sharedCount.increase();
            count++;
        }
    }
}
