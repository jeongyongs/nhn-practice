package com.nhnacademy.exam;

import java.io.IOException;
import java.lang.Thread.State;
import com.nhnacademy.counter.SharedCount;
import com.nhnacademy.counter.SharedCounter;

public class Exam03 {

    private static final String DEFAULT = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";

    @SuppressWarnings("all")
    public static void main(String[] args) throws InterruptedException, IOException {
        SharedCount count = new SharedCount();
        SharedCounter counter1 = new SharedCounter(count);
        SharedCounter counter2 = new SharedCounter(count);

        counter1.start();
        counter2.start();

        State state1 = counter1.getThread().getState();
        State state2 = counter2.getThread().getState();
        State current1 = null;
        State current2 = null;

        System.out.printf("%s, %s%n", state1, state2);

        while (counter1.getThread().isAlive() || counter2.getThread().isAlive()) {
            if ((current1 = counter1.getThread().getState()) != state1
                    || (current2 = counter2.getThread().getState()) != state2) {
                String message1 = null;
                String message2 = null;
                try {
                    message1 = current1.toString();
                    message2 = current2.toString();
                } catch (Exception ignore) {
                    continue;
                }

                if (current1 != state1) {
                    message1 = GREEN + current1 + DEFAULT;
                }
                if (current2 != state2) {
                    message2 = GREEN + current2 + DEFAULT;
                }

                System.out.printf("%n%n%n%n%n%nthread1 : %s%nthread2 : %s%n%n", message1, message2);
                state1 = current1;
                state2 = current2;
                Thread.sleep(100);
            }
        }
    }
}
