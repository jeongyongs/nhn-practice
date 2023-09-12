package com.nhnacademy.counter;

public class SyncronizedSharedCount implements Count {

    private int count;

    public SyncronizedSharedCount() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public synchronized void increase() {
        setCount(getCount() + 1);
    }
}
