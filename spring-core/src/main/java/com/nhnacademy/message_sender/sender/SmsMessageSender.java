package com.nhnacademy.message_sender.sender;

import com.nhnacademy.message_sender.annotation.HelloWorld;
import com.nhnacademy.message_sender.domain.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!dev")
public class SmsMessageSender implements MessageSender {
    @Override
    @HelloWorld
    public void sendMessage(User user, String message) {
        System.out.println("SMS Message Sent to " + user.getPhoneNumber() + " : " + message);
    }
}
