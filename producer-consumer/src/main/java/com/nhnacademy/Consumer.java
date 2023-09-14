package com.nhnacademy;

/**
 * 소비자 클래스입니다.
 */
public class Consumer implements Runnable {

    private static int count = 0;

    private int consumerId;
    private Resource resource;

    /**
     * 소비자를 생성합니다.
     * 
     * @param resource 관리할 자원입니다.
     */
    public Consumer(Resource resource) {
        consumerId = ++count;
        this.resource = resource;
    }

    @Override
    public void run() {
        proccess();
    }

    private void proccess() {
        try {
            resource.get(this);
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 자원 접근 대기열에 추가하도록 요청합니다.
     */
    public void visit() {
        resource.addWaiting(this);
    }

    @Override
    public String toString() {
        return "Consumer" + consumerId;
    }
}
