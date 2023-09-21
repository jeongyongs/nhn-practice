package com.nhnacademy.exam;

import org.json.JSONObject;
import com.nhnacademy.exam.exam03.Address;
import com.nhnacademy.exam.exam03.Person;

public class Exam03 {

    public static void main(String[] args) {
        Person person = new Person("아카데미", 20, new Address("김해", 12345));
        JSONObject json = new JSONObject(person);

        json.getJSONObject("address").put("city", "성남");

        System.out.println(json);
    }
}
