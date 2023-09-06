package com.nhnacademy;

public class LoggerExample {

    public static void main(String[] args) {
        final int a = 10;
        final int b = 20;

        sum(a, b);
    }

    private static int sum(int a, int b) {
        MyLogger.getLogger().info(String.format("덧셈 수행 : %d + %d", a, b));
        MyLogback.getLogger().info(String.format("덧셈 수행 : %d + %d", a, b));

        return a + b;
    }
}
