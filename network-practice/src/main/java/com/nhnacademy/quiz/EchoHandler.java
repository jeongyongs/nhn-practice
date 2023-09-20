package com.nhnacademy.quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 클라이언트와 연결하여 요청을 처리하는 클래스입니다.
 */
public class EchoHandler implements Runnable {

    private static final List<EchoHandler> handlers = new ArrayList<>();

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    private EchoHandler(Socket socket) {
        handlers.add(this);
        this.socket = socket;
    }

    /**
     * 클라이언트의 요청을 처리하는 핸들러를 생성합니다.
     * 
     * @param socket 클라이언트와 연결된 소켓입니다.
     * @return 핸들러를 반환합니다.
     */
    public static EchoHandler from(Socket socket) {
        return new EchoHandler(socket);
    }

    @Override
    public void run() {
        try (BufferedReader reader =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer =
                        new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            this.reader = reader;
            this.writer = writer;
            process();

        } catch (IOException ignore) {
        }
    }

    private void process() throws IOException {
        String connectMessage = socket.getRemoteSocketAddress() + "님이 연결되었습니다.";
        System.out.println(connectMessage);
        broadcast(connectMessage);

        Thread.interrupted();

        while (!Thread.interrupted()) {
            write(read());
        }

        String disconnectMessage = socket.getRemoteSocketAddress() + "님과 연결이 끊겼습니다.";
        System.out.println(disconnectMessage);
        broadcast(disconnectMessage);
    }

    private void broadcast(String message) {
        handlers.stream().forEach(handler -> {
            try {
                handler.write(message);
            } catch (IOException ignore) {
                Thread.currentThread().interrupt();
            }
        });
    }

    private String read() throws IOException {
        String message;
        if ((message = reader.readLine()) == null) {
            Thread.currentThread().interrupt();
        }
        return message;
    }

    private void write(String message) throws IOException {
        writer.write(message + System.lineSeparator());
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(12345);

        while (!Thread.interrupted()) {
            executorService.submit(EchoHandler.from(serverSocket.accept()));
        }

        serverSocket.close();
    }
}
