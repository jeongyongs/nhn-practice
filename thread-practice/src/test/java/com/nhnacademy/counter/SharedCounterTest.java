package com.nhnacademy.counter;

@SuppressWarnings("all")
public class SharedCounterTest {

    public static void main(String[] args) {
        Count count1;
        Count count2;

        loop((count1 = new SyncronizedSharedCount()));
        System.out.println("total : " + count1.getCount() + "\n");

        loop((count2 = new SharedCount()));
        System.out.println("total : " + count2.getCount());
    }

    private static void loop(Count sharedCount) {
        long mean = 0;
        int loop = 100;
        for (int i = 0; i < loop; i++) {
            mean += test(sharedCount);
        }
        System.out.printf("%,d μs%n", mean / loop / 1_000);
    }

    private static long test(Count sharedCount) {
        long startAt = System.nanoTime();

        SharedCounter sharedCounter1 = new SharedCounter(sharedCount);
        SharedCounter sharedCounter2 = new SharedCounter(sharedCount);

        sharedCounter1.start();
        sharedCounter2.start();

        while (sharedCounter1.isAlive() || sharedCounter2.isAlive()) {
        }

        return System.nanoTime() - startAt;
    }
}
