package com.nhnacademy.edu.springframework.messagesender.sender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;

public class EmailMessageSender implements MessageSender {
    public EmailMessageSender() {
        System.out.println("Email Message sender has been created!");
    }

    @Override
    public void sendMessage(User user, String message) {
        System.out.println("Email Message sender: " + user.getEmail() + ", " + message);
    }

    public void destroy() {
        System.out.println("destroy method called in EmailMessageSender");
    }
}
