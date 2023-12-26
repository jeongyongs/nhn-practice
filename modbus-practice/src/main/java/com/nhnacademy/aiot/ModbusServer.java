package com.nhnacademy.aiot;

import java.io.IOException;
import java.net.ServerSocket;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ModbusServer implements Runnable {

    private static final String SERVER_ERROR_MESSAGE = "서버 실행 중 문제가 발생했습니다.";
    private static final int DEFAULT_PORT = 502;

    private final Thread thread;
    private final int port;
    private ServerSocket serverSocket;

    public ModbusServer(int port) {
        thread = new Thread(this);
        this.port = port;
    }

    public ModbusServer() {
        this(DEFAULT_PORT);
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    @Override
    public void run() {
        try {
            preprocess();
            while (!Thread.interrupted()) {
                process();
            }
            postprocess();

        } catch (IOException e) {
            log.error(SERVER_ERROR_MESSAGE, e);
        }
    }


    private void preprocess() throws IOException {
        serverSocket = new ServerSocket(port);
    }

    private void process() {
        //
    }

    private void postprocess() throws IOException {
        serverSocket.close();
    }
}
