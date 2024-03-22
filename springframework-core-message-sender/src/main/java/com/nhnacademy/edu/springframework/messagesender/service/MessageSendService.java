package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.sender.MessageSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageSendService {
    private MessageSender messageSender;
    private String phoneNumber;

    public MessageSendService(MessageSender messageSender, @Value("${phoneNumber}") String phoneNumber) {
        this.messageSender = messageSender;
        this.phoneNumber = phoneNumber;
        System.out.println("MessageSendService constructor has been invoked!");
    }

    public void doSendMessage(User user, String message) {
        user.setPhoneNumber(phoneNumber);
        messageSender.sendMessage(user, message);
    }
}
