package com.nhnacademy.message_sender.sender;

import com.nhnacademy.message_sender.domain.User;

public interface MessageSender {
    void sendMessage(User user, String message);
}
