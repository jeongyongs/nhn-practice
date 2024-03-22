package com.nhnacademy.aop.component;

public class TargetB implements BInterface {
    @Override
    public void method() {
        System.out.println("타겟B의 메소드가 호출되었습니다.");
    }
}
