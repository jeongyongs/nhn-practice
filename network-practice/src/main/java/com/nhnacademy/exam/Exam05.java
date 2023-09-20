package com.nhnacademy.exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam05 {

    public static class Connection implements Runnable {

        private Socket socket;

        private Connection(Socket socket) {
            this.socket = socket;
        }

        public static Connection from(Socket socket) {
            return new Connection(socket);
        }

        @Override
        public void run() {
            preprocess();

            try (BufferedReader reader =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter writer =
                            new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                process(reader, writer);

            } catch (IOException ignore) {
            }

            postprocess();
        }

        private void preprocess() {
            System.out.println(socket.getRemoteSocketAddress() + "님과 연결되었습니다.");
        }

        private void process(BufferedReader reader, BufferedWriter writer) throws IOException {
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                writer.write("echo: " + readLine + System.lineSeparator());
                writer.flush();
            }
        }

        private void postprocess() {
            System.out.println("연결이 끊어졌습니다.");
            try {
                socket.close();
            } catch (IOException ignore) {
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(12345);

        while (!Thread.interrupted()) {
            executorService.submit(Connection.from(serverSocket.accept()));
        }
    }
}
