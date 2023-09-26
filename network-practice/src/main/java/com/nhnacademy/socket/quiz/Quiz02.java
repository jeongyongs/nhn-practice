package com.nhnacademy.socket.quiz;

import java.net.Socket;

public class Quiz02 {

    public static void main(String[] args) {
        for (int i = 0; i < 65536; i++) {
            checkPortIsOpen(i);
        }
    }

    @SuppressWarnings("all")
    private static void checkPortIsOpen(int i) {
        try (Socket socket = new Socket("localhost", i)) {
            System.out.println(i + "번 포트가 열려 있습니다.");
            System.out.println("My: " + socket.getLocalSocketAddress());
            System.out.println("Other: " + socket.getRemoteSocketAddress());
        } catch (Exception ignore) {
        }
    }
}
