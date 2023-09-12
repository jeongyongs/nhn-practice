package com.nhnacademy.counter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class CounterTest {

    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter("테스트1", 3);
        Counter counter2 = new Counter("테스트2", 3);

        counter1.run();
        counter2.run();
    }

    @AfterEach
    void 초기화() {
        System.setOut(System.out);
    }

    @Test
    void 테스트() throws InterruptedException {
        // given
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        final int maxCount = 5;
        final String name = "테스트";
        Counter counter = new Counter(name, maxCount);

        // when
        counter.run();

        // then
        String[] strings = outputStream.toString().split("\n");
        assertEquals(name + " : " + maxCount, strings[strings.length - 1]);
    }
}
