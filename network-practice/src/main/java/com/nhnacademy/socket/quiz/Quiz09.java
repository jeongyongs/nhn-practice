package com.nhnacademy.socket.quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Quiz09 {

    public static void main(String[] args) {
        int port = 1234;
        if (args.length != 0) {
            port = Integer.parseInt(args[0]);
        }

        try (ServerSocket serverSocket = new ServerSocket(port);
                Socket client = serverSocket.accept();
                BufferedReader bufferedReader =
                        new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter bufferedWriter =
                        new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));) {

            process(bufferedReader, bufferedWriter);

        } catch (IOException ignore) {
        }
    }

    private static void process(BufferedReader bufferedReader, BufferedWriter bufferedWriter)
            throws IOException {
        bufferedWriter.write(bufferedReader.readLine());
        bufferedWriter.flush();
    }
}
