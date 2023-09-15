package com.nhnacademy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;

/**
 * 매장 클래스입니다.
 */
@Slf4j
public class Store {

    private ExecutorService waitingList;
    private Semaphore stock;
    private int stockSize;
    private int waitingCount;
    private int inCount;

    /**
     * 매장을 생성합니다.
     * 
     * @param stockSize 매대의 크기입니다.
     * @param waitingSize 대기열 크기입니다.
     */
    public Store(int stockSize, int waitingSize) {
        waitingList = Executors.newFixedThreadPool(waitingSize);
        stock = new Semaphore(stockSize);
        this.stockSize = stockSize;
        waitingCount = 0;
        inCount = 0;
    }

    /**
     * 재고를 채웁니다.
     * 
     * @throws InterruptedException 인터럽트가 발생할 경우
     */
    public synchronized void add() throws InterruptedException {
        while (isFull()) {
            log.info("재고가 가득 차서 대기합니다.");
            wait();
        }
        stock.acquire();
        log.info("재고가 들어왔습니다. (재고: {})", getResourcesCount());
        notifyAll();
    }

    private boolean isFull() {
        return stock.availablePermits() == 0;
    }

    /**
     * 매장에 입장합니다.
     * 
     * @param consumer 매장에 입장할 소비자입니다.
     * @throws InterruptedException 인터럽트가 발생할 경우
     */
    public void enter(Consumer consumer) throws InterruptedException {
        waitingCount--;
        log.info("{}님이 매장에 입장하였습니다. (매장인원: {})", consumer, ++inCount);
        get(consumer);
        inCount--;
    }

    @SuppressWarnings("all")
    private synchronized void get(Consumer consumer) throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        log.info("{}님이 계산 중입니다.", consumer);
        Thread.sleep(ThreadLocalRandom.current().nextLong(1_000, 10_000)); // 물건을 사는데 걸리는 시간
        stock.release();
        log.info("{}님이 상품을 구매했습니다. (재고: {})", consumer, getResourcesCount());
        notifyAll();
    }

    private boolean isEmpty() {
        return stock.availablePermits() == stockSize;
    }

    private int getResourcesCount() {
        return stockSize - stock.availablePermits();
    }

    /**
     * 매장 입장 대기열에 소비자를 등록합니다.
     * 
     * @param consumer 대기열에 등록할 소비자입니다.
     */
    public void addWaiting(Consumer consumer) {
        waitingList.submit(consumer);
        log.info("{}님이 대기열에 등록되었습니다. (대기인원: {})", consumer, ++waitingCount);
    }

    /**
     * 현재 매장 정보를 가져옵니다.
     * 
     * @return 매장 정보를 반환합니다.
     */
    public String getInfo() {
        String result = "";

        result += String.format("│ %-7s : %3d │%n", "대기열 인원", waitingCount);
        result += String.format("│ %-7s : %3d │%n", "매장안 인원", inCount);
        result += String.format("│ %-10s : %3d │%n", "재 고", getResourcesCount());

        return result;
    }
}
