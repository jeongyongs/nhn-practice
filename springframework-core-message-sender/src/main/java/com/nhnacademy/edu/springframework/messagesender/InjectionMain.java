package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectionMain {
    private static final String EMAIL = "aiot0127@nhnacademy.com";
    private static final String PHONE_NUMBER = "010-0000-0000";
    private static final String MESSAGE_SEND_SERVICE = "messageSendService";
    private static final String MESSAGE = "테스트";

    public static void main(String[] args) {
        User user = new User(EMAIL, PHONE_NUMBER);

        try (ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml")) {
            classPathXmlApplicationContext.getBean(MESSAGE_SEND_SERVICE, MessageSendService.class)
                    .doSendMessage(user, MESSAGE);
        }
    }
}
