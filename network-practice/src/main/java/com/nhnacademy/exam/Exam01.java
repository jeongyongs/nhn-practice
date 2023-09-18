package com.nhnacademy.exam;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Exam01 {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 12345);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        while (true) {
            byte[] message = new byte[1024];
            inputStream.read(message);
            for (byte b : message) {
                System.out.print((char) b);
            }
            outputStream.write("socket practice\n".getBytes());

            Thread.sleep(1000);
        }
    }
}
