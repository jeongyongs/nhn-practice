package com.nhnacademy.dice;

public class Dice {

    private int number;

    public Dice(int number) {
        if (number < 1 || number > 6) {
            throw new IllegalArgumentException("잘못된 주사위 값입니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
