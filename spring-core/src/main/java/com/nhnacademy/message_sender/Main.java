package com.nhnacademy.message_sender;

import com.nhnacademy.message_sender.config.MainConfig;
import com.nhnacademy.message_sender.domain.User;
import com.nhnacademy.message_sender.service.MessageSendService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        User user = new User("email@nhnacademy.com", "010-0000-0000");
        context.getBean("messageSendService", MessageSendService.class)
                .doSendMessage(user, "테스트 메세지");
    }
}
