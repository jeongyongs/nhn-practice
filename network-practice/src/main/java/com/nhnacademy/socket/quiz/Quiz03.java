package com.nhnacademy.socket.quiz;

import java.net.Socket;

public class Quiz03 {

    public static void main(String[] args) {
        try (Socket socket = new Socket("ems.nhnacademy.com", 12345)) {
            System.out.println(socket.getRemoteSocketAddress());
            System.out.println(socket.getLocalSocketAddress());
        } catch (Exception ignore) {
        }
    }
}
