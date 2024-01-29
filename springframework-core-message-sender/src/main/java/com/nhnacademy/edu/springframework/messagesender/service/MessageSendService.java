package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.sender.MessageSender;

public class MessageSendService {
    private MessageSender messageSender;

    public MessageSendService() {
        // default constructor
    }

    public MessageSendService(MessageSender messageSender) {
        this.messageSender = messageSender;
        System.out.println("Constructor");
    }

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
        System.out.println("Setter");
    }

    public void doSendMessage(User user, String message) {
        messageSender.sendMessage(user, message);
    }
}
