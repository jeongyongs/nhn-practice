package com.nhnacademy.exam;

public class Exam01 {

    public static void main(String[] args) {
        Thread thread = new Thread();

        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
    }
}
