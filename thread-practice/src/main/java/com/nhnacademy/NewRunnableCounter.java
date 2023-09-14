package com.nhnacademy;

import static java.text.NumberFormat.getInstance;

/**
 * 쓰레드로 동작하는 카운터 클래스입니다.
 */
public class NewRunnableCounter implements Runnable {

    private Thread thread;
    private String name;
    private int count;
    private SharedResource resource;

    /**
     * 쓰레드로 동작하는 카운터를 생성합니다.
     */
    public NewRunnableCounter(String name, SharedResource resource) {
        thread = new Thread(this);
        this.name = name;
        count = 0;
        this.resource = resource;
    }

    /**
     * 카운터 쓰레드를 구동합니다.
     */
    public void start() {
        thread.start();
    }

    /**
     * 쓰레드에게 중단 요청을 보냅니다.
     */
    public void stop() {
        thread.interrupt();
    }

    @Override
    public void run() {
        while (!Thread.interrupted() && count < 10) {
            resource.increase();
            count++;
        }
        System.out.println(name + " : " + getInstance().format(count) + " done!");
    }

    /**
     * 쓰레드가 동작 중인지 확인합니다.
     * 
     * @return 쓰레드가 동작 중이면 true를 반환합니다.
     */
    public boolean isAlive() {
        return thread.isAlive();
    }

    public void printState() {
        System.out.println(name + " : " + thread.getState());
    }
}
