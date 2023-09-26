package com.nhnacademy.socket.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Quiz04 {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            process(socket);
        } catch (IOException ignore) {
        }
    }

    private static void process(Socket socket) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String message;

        while (!(message = bufferedReader.readLine()).equals("exit")) {
            System.out.println("message: " + message);
        }
    }
}
