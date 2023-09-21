package com.nhnacademy.quiz;

import org.json.JSONObject;

public class Quiz01 {

    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        JSONObject address = new JSONObject();

        json.put("address", address);
        json.put("name", "nhn");
        address.put("code", 13487);
        address.put("city", "Seongnam");

        System.out.println(json);
    }
}
