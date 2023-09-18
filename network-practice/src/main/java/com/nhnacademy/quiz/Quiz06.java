package com.nhnacademy.quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Quiz06 {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
                BufferedReader bufferedReader =
                        new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bufferedWriter =
                        new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {

            process(bufferedReader, bufferedWriter);

        } catch (IOException ignore) {
        }
    }

    private static void process(BufferedReader bufferedReader, BufferedWriter bufferedWriter)
            throws IOException {
        String outputString;

        while (!(outputString = bufferedReader.readLine()).equals("exit")) {
            System.out.println("message: " + outputString);
            bufferedWriter.write("message: test\n");
            bufferedWriter.flush();
        }
    }
}
