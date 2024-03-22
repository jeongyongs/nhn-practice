package com.nhnacademy.aop;

import com.nhnacademy.aop.component.BInterface;
import com.nhnacademy.aop.component.TartgetA;
import com.nhnacademy.aop.proxy.ExtendsProxy;
import com.nhnacademy.aop.proxy.ImplementationProxy;

public class Main {
    public static void main(String[] args) {
        TartgetA tartgetA = new ExtendsProxy();
        BInterface targetB = new ImplementationProxy();

        tartgetA.method();
        targetB.method();
    }
}
