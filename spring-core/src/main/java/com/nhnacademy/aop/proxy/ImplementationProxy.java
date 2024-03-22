package com.nhnacademy.aop.proxy;

import com.nhnacademy.aop.aspect.Aspect;
import com.nhnacademy.aop.component.BInterface;
import com.nhnacademy.aop.component.TargetB;

public class ImplementationProxy implements BInterface {
    @Override
    public void method() {
        new TargetB().method();
        new Aspect().advice();
    }
}
