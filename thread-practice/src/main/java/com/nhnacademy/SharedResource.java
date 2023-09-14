package com.nhnacademy;

import static java.text.NumberFormat.getInstance;
import java.util.ArrayList;
import java.util.List;

/**
 * 공유 자원 클래스입니다.
 */
public class SharedResource {

    private int count;
    private List<NewRunnableCounter> counters;

    /**
     * 공유 자원을 생성합니다.
     */
    public SharedResource() {
        count = 0;
        counters = new ArrayList<>();
    }

    /**
     * 공유 자원을 1 증가 시킵니다.
     */
    public void increase() {
        synchronized (this) {
            count++;
            counters.stream().forEach(NewRunnableCounter::printState);
        }
    }

    @Override
    public String toString() {
        return "SharedResource [count=" + getInstance().format(count) + "]";
    }

    public void addCounter(NewRunnableCounter counter) {
        counters.add(counter);
    }
}
