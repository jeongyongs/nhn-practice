package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.annotation.SMS;
import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageSendService {
    private MessageSender messageSender;

    public MessageSendService() {
        // default constructor
    }

    @Autowired
    public MessageSendService(@SMS MessageSender messageSender) {
        this.messageSender = messageSender;
        System.out.println("MessageSendService constructor has been invoked!");
    }

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
        System.out.println("MessageSendService setter has been invoked!");
    }

    public void doSendMessage(User user, String message) {
        messageSender.sendMessage(user, message);
    }
}
