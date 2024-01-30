package com.nhnacademy.edu.springframework.messagesender.config;

import com.nhnacademy.edu.springframework.messagesender.sender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.sender.SmsMessageSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("beans.xml")
public class MainConfig {
    @Bean(value = "smsMessageSender", initMethod = "init")
    public MessageSender smsMessageSender() {
        return new SmsMessageSender();
    }
}
