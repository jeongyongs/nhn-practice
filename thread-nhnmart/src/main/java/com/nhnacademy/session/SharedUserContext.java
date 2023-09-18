package com.nhnacademy.session;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SharedUserContext implements Runnable {

    private static final ThreadLocal<Session> userContext = new ThreadLocal<>();
    private final Integer userId;
    private UserStore userStore = new UserStore();

    public SharedUserContext(Integer userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        String userName = userStore.getUserNameForUserId(userId);
        userContext.set(new Session(userName));
        log.info("session userId: {}, userName: {}", userId, userContext.get());
    }
}
