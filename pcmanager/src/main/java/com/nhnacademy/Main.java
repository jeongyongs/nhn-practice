package com.nhnacademy;

public class Main {

    public static void main(String[] args) {
        PCManager pCManager = new PCManager(5);
        Thread producer = new Thread(pCManager::produce);
        Thread consumer = new Thread(pCManager::consume);

        producer.start();
        consumer.start();
    }
}
