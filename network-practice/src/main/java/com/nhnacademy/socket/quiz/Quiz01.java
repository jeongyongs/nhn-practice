package com.nhnacademy.socket.quiz;

import java.io.IOException;
import java.net.Socket;

public class Quiz01 {

    public static void main(String[] args) {
        for (int i = 1; i < 65536; i++) {
            try {
                Socket socket = new Socket("localhost", i);
                System.out.println(i + "가 열려 있습니다.");
                socket.close();
            } catch (IOException ignore) {
            }
        }
    }
}
