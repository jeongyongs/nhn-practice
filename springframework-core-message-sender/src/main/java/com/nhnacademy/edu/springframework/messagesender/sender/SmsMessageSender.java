package com.nhnacademy.edu.springframework.messagesender.sender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;

public class SmsMessageSender implements MessageSender {
    @Override
    public void sendMessage(User user, String message) {
        System.out.println("SMS Message sender: " + user.getPhoneNumber() + ", " + message);
    }

    public void init() {
        System.out.println("init method called in SmsMessageSender");
    }

    public void destroy() {
        System.out.println("destroy method called in SmsMessageSender");
    }
}