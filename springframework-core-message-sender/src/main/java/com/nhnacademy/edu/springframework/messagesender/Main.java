package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final String EMAIL = "aiot0127@nhnacademy.com";
    private static final String PHONE_NUMBER = "010-0000-0000";
    private static final String MESSAGE_SEND_SERVICE = "messageSendService";
    private static final String MESSAGE = "테스트";
    private static final String CONFIGURATION_PACKAGE = "com.nhnacademy.edu.springframework.messagesender.config";

    public static void main(String[] args) {
        User user = new User(EMAIL, PHONE_NUMBER);

        try (AnnotationConfigApplicationContext annotationConfigApplicationContext =
                     new AnnotationConfigApplicationContext(CONFIGURATION_PACKAGE)) {
            annotationConfigApplicationContext.getBean(MESSAGE_SEND_SERVICE, MessageSendService.class)
                    .doSendMessage(user, MESSAGE);
        }
    }
}
