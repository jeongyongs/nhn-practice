package com.nhnacademy.socket.quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Quiz07 {

    public static void main(String[] args) {
        try (Socket socket = new Socket("ems.nhnacademy.com", 12345);
                BufferedReader bufferedReader =
                        new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bufferedWriter =
                        new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {

            process(bufferedReader, bufferedWriter);

        } catch (IOException ignore) {
        }
    }

    @SuppressWarnings("all")
    private static void process(BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        Thread receiver = new Thread(() -> {
            try {
                while (true) {
                    System.out.println(bufferedReader.readLine());
                }
            } catch (IOException ignore) {
            }
        });
        receiver.start();

        Thread sender = new Thread(() -> {
            try (BufferedReader inputReader =
                    new BufferedReader(new InputStreamReader(System.in));) {
                while (true) {
                    // bufferedWriter.write(inputReader.readLine() + "\n");
                    bufferedWriter.write("test\n");
                    bufferedWriter.flush();
                    Thread.sleep(1000);
                }
            } catch (Exception ignore) {
            }
        });
        sender.start();

        try {
            receiver.join();
            sender.join();
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
    }
}
