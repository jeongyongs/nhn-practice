package com.nhnacademy.session;

import java.util.HashMap;
import java.util.Map;

public class UserStore {

    private final Map<Integer, String> userMap = new HashMap<>();

    public UserStore() {
        userMap.put(1, "marco");
        userMap.put(2, "test");
    }

    public String getUserNameForUserId(Integer userId) {
        return userMap.get(userId);
    }
}
