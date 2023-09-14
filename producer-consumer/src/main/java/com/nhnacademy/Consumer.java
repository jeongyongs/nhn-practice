package com.nhnacademy;

/**
 * 소비자 클래스입니다.
 */
public class Consumer implements Runnable {

    private static int count = 0;

    private int consumerId;
    private Store store;

    /**
     * 소비자를 생성합니다.
     * 
     * @param store 방문할 매장입니다.
     */
    public Consumer(Store store) {
        consumerId = ++count;
        this.store = store;
    }

    @Override
    public void run() {
        proccess();
    }

    private void proccess() {
        try {
            store.enter(this);
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 매장에 들어갈 수 있도록 요청을 보냅니다.
     */
    public void visit() {
        store.addWaiting(this);
    }

    @Override
    public String toString() {
        return "Consumer" + consumerId;
    }
}
