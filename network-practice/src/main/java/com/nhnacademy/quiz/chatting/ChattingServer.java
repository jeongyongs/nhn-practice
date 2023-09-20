package com.nhnacademy.quiz.chatting;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 채팅 서버 클래스입니다.
 */
public class ChattingServer implements Runnable {

    private Thread thread;
    private int port;
    private ServerSocket serverSocket;

    private ChattingServer(int port) {
        thread = new Thread(this);
        this.port = port;
    }

    /**
     * 채팅 서버를 생성합니다.
     * 
     * @param port 서버 포트입니다.
     * @return 채팅 서버를 반환합니다.
     */
    public static ChattingServer port(int port) {
        return new ChattingServer(port);
    }

    /**
     * 채팅 서버를 실행합니다.
     */
    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        try {
            preprocess();
            process();
            postprocess();
        } catch (IOException ignore) {
            Thread.currentThread().interrupt();
        }
    }

    private void preprocess() throws IOException {
        serverSocket = new ServerSocket(port);
    }

    private void process() throws IOException {
        while (!Thread.interrupted()) {
            Connection.from(serverSocket.accept()).start();
        }
    }

    private void postprocess() throws IOException {
        serverSocket.close();
    }
}
