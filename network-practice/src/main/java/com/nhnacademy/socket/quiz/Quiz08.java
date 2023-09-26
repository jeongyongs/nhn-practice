package com.nhnacademy.socket.quiz;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Quiz08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket client = serverSocket.accept();

        System.out.printf("Client [%s]가 연결되었습니다.%n", client.getRemoteSocketAddress());
    }
}
