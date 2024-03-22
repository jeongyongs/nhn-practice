package com.nhnacademy.edu.springframework.messagesender.sender;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Profile("real")
public class DoorayMessageSender implements MessageSender {
    @Override
    public void sendMessage(User user, String message) {
        new DoorayHookSender(new RestTemplate(), "https://hook.dooray.com/services/3204376758577275363/3727553265487230503/DIiyr9z0ROKJksd5yMFedQ")
                .send(DoorayHook.builder()
                        .botName("이정용")
                        .text("안녕하세요.")
                        .build());
    }
}
