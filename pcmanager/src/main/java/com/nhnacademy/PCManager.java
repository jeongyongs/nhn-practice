package com.nhnacademy;

import java.util.LinkedList;
import lombok.extern.slf4j.Slf4j;

/**
 * 생산자-소비자 관리자 클래스입니다.
 */
@Slf4j
@SuppressWarnings("all")
public class PCManager {

    private final LinkedList<Integer> buffer;
    private final int bufferSize;

    /**
     * 생산자-소비자 관리자를 생성합니다.
     * 
     * @param bufferSize 버퍼의 크기입니다.
     */
    public PCManager(int bufferSize) {
        buffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    /**
     * 생산합니다.
     * 
     * @throws InterruptedException 인터럽트가 발생할 경우
     */
    public void produce() {
        try {
            loopProduce();
        } catch (InterruptedException ignore) {
            throwInteruptToCurrentThread();
        }
    }

    private void throwInteruptToCurrentThread() {
        Thread.currentThread().interrupt();
    }

    private void loopProduce() throws InterruptedException {
        while (true) {
            produceProcess();
        }
    }

    private synchronized void produceProcess() throws InterruptedException {
        while (isFull()) {
            wait();
        }
        buffer.add(0);
        log.info("생산자-데이터 생성 : {}", buffer.size());
        notifyAll();

        Thread.sleep(100);
    }

    private boolean isFull() {
        return buffer.size() >= bufferSize;
    }

    /**
     * 소비합니다.
     * 
     * @throws InterruptedException 인터럽트가 발생할 경우
     */
    public void consume() {
        try {
            loopConsume();
        } catch (InterruptedException ignore) {
            throwInteruptToCurrentThread();
        }
    }

    private void loopConsume() throws InterruptedException {
        while (true) {
            consumeProcess();
        }
    }

    private synchronized void consumeProcess() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        buffer.poll();
        log.info("소비자-소비 : {}", buffer.size());
        notifyAll();

        Thread.sleep(100);
    }

    private boolean isEmpty() {
        return buffer.isEmpty();
    }
}
