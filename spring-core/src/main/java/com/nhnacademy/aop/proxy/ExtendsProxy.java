package com.nhnacademy.aop.proxy;

import com.nhnacademy.aop.aspect.Aspect;
import com.nhnacademy.aop.component.TartgetA;

public class ExtendsProxy extends TartgetA {
    @Override
    public void method() {
        new Aspect().advice();
        super.method();
    }
}
