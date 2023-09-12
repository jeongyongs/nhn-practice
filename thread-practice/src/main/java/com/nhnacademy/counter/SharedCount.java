package com.nhnacademy.counter;

public class SharedCount implements Count {

    private int count;

    public SharedCount() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increase() {
        setCount(getCount() + 1);
    }
}
