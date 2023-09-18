package com.nhnacademy.quiz;

import java.net.Socket;

public class Quiz02 {

    public static void main(String[] args) {
        for (int i = 0; i < 65536; i++) {
            checkPortIsOpen(i);
        }
    }

    private static void checkPortIsOpen(int i) {
        try (Socket socket = new Socket("localhost", i)) {
            System.out.println(i + "번 포트가 열려 있습니다.");
        } catch (Exception ignore) {
            //
        }
    }
}
