package com.nhnacademy;

import java.util.concurrent.Semaphore;
import lombok.extern.slf4j.Slf4j;

/**
 * 자원 클래스입니다.
 */
@Slf4j
public class Resource {

    private static final String DEFAULT = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";

    private Semaphore resources;
    private int size;

    /**
     * 자원을 생성합니다.
     * 
     * @param size 자원을 저장할 수 있는 공간의 크기입니다.
     */
    public Resource(int size) {
        resources = new Semaphore(size);
        this.size = size;
    }

    /**
     * 자원을 추가합니다.
     * 
     * @throws InterruptedException 인터럽트가 발생할 경우
     */
    public synchronized void add() throws InterruptedException {
        while (isFull()) {
            log.info("자원이 가득 차서 대기합니다.");
            wait();
        }
        resources.acquire();
        log.info("{}자원이 생성되었습니다. (개수 : {}){}", GREEN, getResourcesCount(), DEFAULT);
        notifyAll();
    }

    /**
     * 자원을 제거합니다.
     * 
     * @throws InterruptedException 인터럽트가 발생할 경우
     */
    public synchronized void get() throws InterruptedException {
        while (isEmpty()) {
            log.info("자원이 부족하여 대기합니다.");
            wait();
        }
        resources.release();
        log.info("{}자원이 제거되었습니다. (개수 : {}){}", RED, getResourcesCount(), DEFAULT);
        notifyAll();
    }

    private boolean isFull() {
        return resources.availablePermits() == 0;
    }

    private boolean isEmpty() {
        return resources.availablePermits() == size;
    }

    private int getResourcesCount() {
        return size - resources.availablePermits();
    }
}
