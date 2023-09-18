package com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import com.nhnacademy.customer.Customer;
import com.nhnacademy.mart.Mart;

public class Main {

    public static void main(String[] args) {
        Mart mart = new Mart();
        mart.prepareBeforeOpen();

        IntStream.range(0, 60).forEach(i -> Main.createCustomer(mart));
    }

    private static void createCustomer(Mart mart) {
        Customer customer = Customer.of("customer");
        customer.setDestination(mart);
        customer.start();
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1_000));
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
    }
}
