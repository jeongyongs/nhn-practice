package com.nhnacademy.socket.exam;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Exam02 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        OutputStream outputStream = socket.getOutputStream();

        for (int i = 0; i < 20; i++) {
            outputStream.write("Hello, World !\n".getBytes());
        }
        socket.close();
    }
}
