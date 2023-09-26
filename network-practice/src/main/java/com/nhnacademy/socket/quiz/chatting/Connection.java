package com.nhnacademy.socket.quiz.chatting;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 클라이언트와 연결을 담당하는 클래스입니다.
 */
public class Connection implements Runnable {

    private static final List<Connection> connections = new ArrayList<>();

    private Thread thread;
    private Socket socket;
    private String username;
    private Communicator communicator;

    private Connection(Socket socket) {
        connections.add(this);
        thread = new Thread(this);
        this.socket = socket;
        communicator = Communicator.from(socket);
    }

    /**
     * 새로운 연결을 생성합니다.
     * 
     * @param socket 연결된 소켓입니다.
     * @return 연결을 반환합니다.
     */
    public static Connection from(Socket socket) {
        return new Connection(socket);
    }

    /**
     * 연결된 클라이언트와 통신합니다.
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

    private void preprocess() {
        send("사용할 닉네임을 입력해주세요.");
        username = communicator.receive();

        String connectMessage = username + "님이 입장했습니다.";
        System.out.println(connectMessage);
        sendAll(connectMessage);
    }

    private void process() {
        while (!Thread.interrupted()) {
            String message = communicator.receive();
            parseMessage(message);
        }
    }

    private void parseMessage(String message) {
        if (message == null) {
            return;
        }
        if (message.startsWith("@")) {
            String[] splittedMessage = message.split(" ", 2);
            String targetUsername = splittedMessage[0].split("@")[1];
            String msg = splittedMessage[1];
            sendToUser(targetUsername, msg);
            return;
        }
        sendAll(message);
    }

    private void postprocess() throws IOException {
        String disconnectMessage = username + "님이 퇴장했습니다.";
        System.out.println(disconnectMessage);
        sendAll(disconnectMessage);

        communicator.close();
        socket.close();
    }

    private void sendAll(String message) {
        connections.stream().filter(connection -> connection != this)
                .forEach(connection -> connection.send(message));
    }

    private void sendToUser(String username, String message) {
        connections.stream().filter(connection -> connection.isUser(username))
                .forEach(connection -> connection.send(message));
    }

    private boolean isUser(String username) {
        return this.username.equals(username);
    }

    private void send(String message) {
        communicator.send(message);
    }
}
