package com.nhnacademy;

@SuppressWarnings("all")
public class NewRunnableCounterTest {

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        NewRunnableCounter counter1 = new NewRunnableCounter("1", resource);
        NewRunnableCounter counter2 = new NewRunnableCounter("2", resource);

        counter1.printState();
        counter2.printState();

        resource.addCounter(counter1);
        resource.addCounter(counter2);

        counter1.start();
        counter2.start();

        while (counter1.isAlive() || counter2.isAlive()) {
        }

        counter1.printState();
        counter2.printState();

        System.out.println("\n" + resource);
    }
}
