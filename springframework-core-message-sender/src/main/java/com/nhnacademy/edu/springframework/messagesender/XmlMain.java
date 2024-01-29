package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import com.nhnacademy.edu.springframework.messagesender.sender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {
    private static final String EMAIL = "aiot0127@nhnacademy.com";
    private static final String PHONE_NUMBER = "010-0000-0000";
    private static final String BEANS_XML = "beans.xml";
    private static final String SMS_MESSAGE_SENDER = "smsMessageSender";
    private static final String EMAIL_MESSAGE_SENDER = "emailMessageSender";
    private static final String MESSAGE = "테스트";
    private static final String LINE = "-";

    public static void main(String[] args) {
        User user = new User(
                EMAIL,
                PHONE_NUMBER
        );

        try (ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(BEANS_XML)) {
            System.out.println(LINE);
            MessageSender smsMessageSender = classPathXmlApplicationContext.getBean(SMS_MESSAGE_SENDER, MessageSender.class);
            System.out.println(LINE);
            MessageSender smsMessageSender2 = classPathXmlApplicationContext.getBean(SMS_MESSAGE_SENDER, MessageSender.class);
            System.out.println(LINE);
            MessageSender emailMessageSender = classPathXmlApplicationContext.getBean(EMAIL_MESSAGE_SENDER, MessageSender.class);
            System.out.println(LINE);
            MessageSender emailMessageSender2 = classPathXmlApplicationContext.getBean(EMAIL_MESSAGE_SENDER, MessageSender.class);
            System.out.println(LINE);

            new MessageSendService(smsMessageSender)
                    .doSendMessage(user, MESSAGE);
            new MessageSendService(emailMessageSender)
                    .doSendMessage(user, MESSAGE);

            System.out.println(smsMessageSender == smsMessageSender2);
            System.out.println(emailMessageSender == emailMessageSender2);
        }
    }
}
