package com.nhnacademy.edu.springframework.messagesender.sender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.springframework.stereotype.Component;

@Component
public class SmsMessageSender implements MessageSender {
    @Override
    public void sendMessage(User user, String message) {
        System.out.println("SMS Message sender: " + user.getPhoneNumber() + ", " + message);
    }

    public void init() {
        System.out.println("Init method called in SmsMessageSender");
    }

    public void close() {
        System.out.println("destroy method called in SmsMessageSender");
    }
}
