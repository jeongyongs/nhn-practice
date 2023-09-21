package com.nhnacademy.exam.exam03;

public class Address {

    private String city;
    private int code;

    public Address(String city, int code) {
        this.city = city;
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public int getCode() {
        return code;
    }
}
