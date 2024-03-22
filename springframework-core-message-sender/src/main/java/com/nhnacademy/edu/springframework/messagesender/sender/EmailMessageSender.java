package com.nhnacademy.edu.springframework.messagesender.sender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
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
