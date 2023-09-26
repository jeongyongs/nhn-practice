package com.nhnacademy.socket.quiz.chatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 소켓과 메세지를 주고 받는 클래스입니다.
 */
public class Communicator {

    private BufferedReader reader;
    private BufferedWriter writer;

    private Communicator(Socket socket) {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException ignore) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 커뮤니케이터를 생성합니다.
     * 
     * @param socket 통신할 소켓입니다.
     * @return 커뮤니케이터를 반환합니다.
     */
    public static Communicator from(Socket socket) {
        return new Communicator(socket);
    }

    /**
     * 커뮤니케이터를 닫습니다.
     * 
     * @throws IOException 연결에 문제가 생길 경우
     */
    public void close() throws IOException {
        reader.close();
        writer.close();
    }

    /**
     * 연결된 소켓에 메세지를 보냅니다.
     * 
     * @param message 보낼 문자열입니다.
     */
    public void send(String message) {
        try {
            writer.write(message + System.lineSeparator());
            writer.flush();
        } catch (IOException ignore) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 연결된 소켓에서 메세지를 받습니다.
     * 
     * @return 받은 메세지를 반환합니다.
     */
    public String receive() {
        String message = null;

        try {
            message = reader.readLine();
        } catch (IOException ignore) {
            Thread.currentThread().interrupt();
        }

        if (message == null) {
            Thread.currentThread().interrupt();
        }
        return message;
    }
}
