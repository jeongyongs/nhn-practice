package com.nhnacademy.exam;

import org.json.JSONObject;

public class Exam01 {

    public static void main(String[] args) {
        JSONObject json = new JSONObject();

        json.put("name", "jeongyongs");
        json.put("group", "nhnacademy");

        System.out.println(json);
    }
}
