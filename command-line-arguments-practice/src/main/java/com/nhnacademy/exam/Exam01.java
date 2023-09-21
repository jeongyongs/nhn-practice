package com.nhnacademy.exam;

public class Exam01 {

    public static void main(String[] args) {
        for (String arg : args) {
            printEachTypes(arg);
        }
    }

    private static void printEachTypes(String arg) {
        try {
            System.out.println("(float) " + Float.parseFloat(arg));
        } catch (NumberFormatException ignore) {
            System.out.println("(String) " + arg);
        }
    }
}
