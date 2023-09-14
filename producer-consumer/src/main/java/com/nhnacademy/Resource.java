package com.nhnacademy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
    private static final String YELLOW = "\u001B[33m";

    private ExecutorService executorService;
    private Semaphore resources;
    private int size;

    /**
     * 자원을 생성합니다.
     * 
     * @param stockSize 자원을 저장할 수 있는 공간의 크기입니다.
     * @param waitingSize 대기열 크기입니다.
     */
    public Resource(int stockSize, int waitingSize) {
        executorService = Executors.newFixedThreadPool(waitingSize);
        resources = new Semaphore(stockSize);
        this.size = stockSize;
    }

    /**
     * 자원을 추가합니다.
     * 
     * @throws InterruptedException 인터럽트가 발생할 경우
     */
    public synchronized void add() throws InterruptedException {
        while (isFull()) {
            log.info("{}자원이 가득 차서 대기합니다.{}", YELLOW, DEFAULT);
            wait();
        }
        resources.acquire();
        log.info("{}자원이 생성되었습니다. (개수 : {}){}", GREEN, getResourcesCount(), DEFAULT);
        notifyAll();
    }

    /**
     * 자원을 제거합니다.
     * 
     * @param consumer 자원을 가져갈 소비자입니다.
     * @throws InterruptedException 인터럽트가 발생할 경우
     */
    public synchronized void get(Consumer consumer) throws InterruptedException {
        log.info("{}님이 입장하였습니다.", consumer);
        while (isEmpty()) {
            log.info("{}{}님이 대기중입니다.{}", YELLOW, consumer, DEFAULT);
            wait();
        }
        resources.release();
        log.info("{}{}님이 자원을 가져갔습니다. (개수 : {}){}", RED, consumer, getResourcesCount(), DEFAULT);
        notifyAll();
        log.info("{}님이 퇴장하였습니다.", consumer);
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

    /**
     * 자원 접근을 위한 대기열에 소비자를 추가합니다.
     * 
     * @param consumer 대기열에 등록할 소비자입니다.
     */
    public void addWaiting(Consumer consumer) {
        executorService.submit(consumer);
    }
}
