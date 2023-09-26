package com.nhnacademy.socket.quiz;

import com.nhnacademy.socket.quiz.chatting.ChattingServer;

public class Quiz13 {

    public static void main(String[] args) {
        ChattingServer chattingServer = ChattingServer.port(12345);
        chattingServer.start();
    }
}
