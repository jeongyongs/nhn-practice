package com.nhnacademy.customer;

import com.nhnacademy.mart.Mart;

/**
 * 고객 클래스입니다.
 */
public class Customer implements Runnable {

    private static final int DEFAULT_MONEY = 1_000_000;

    private static long count = 0;

    private final long customerId;
    private final String name;
    private long money;
    private Mart mart;
    private Thread thread;

    private Customer(String name, long money) {
        customerId = ++count;
        this.name = name;
        this.money = money;
        thread = new Thread(this);
    }

    /**
     * 고객을 생성합니다.
     * 
     * @param name 고객의 이름입니다.
     * @return 이름이 <code>name</code>인 고객 객체를 반환합니다.
     */
    public static Customer of(String name) {
        return new Customer(name, DEFAULT_MONEY);
    }

    /**
     * 방문할 마트를 선택합니다.
     * 
     * @param mart 방문할 마트입니다.
     */
    public void setDestination(Mart mart) {
        this.mart = mart;
    }

    /**
     * 손님을 동작합니다.
     */
    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        visit();
    }

    private void visit() {
        mart.accept(this);
    }

    @Override
    public String toString() {
        return "Customer" + customerId;
    }
}
