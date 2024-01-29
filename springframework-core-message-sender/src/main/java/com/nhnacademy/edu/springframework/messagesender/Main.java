package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.sender.EmailMessageSender;
import com.nhnacademy.edu.springframework.messagesender.sender.SmsMessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;

public class Main {
    public static void main(String[] args) {
        User user = new User("aiot0127@nhnacademy.com", "010-0000-0000");

        new MessageSendService(new SmsMessageSender())
                .doSendMessage(user, "테스트");
        new MessageSendService((new EmailMessageSender()))
                .doSendMessage(user, "테스트");
    }
}
