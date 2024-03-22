package com.nhnacademy.message_sender.aspect;

import com.nhnacademy.message_sender.domain.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloWorldAspect {
    @Pointcut("execution(void com.nhnacademy.message_sender.sender.*.sendMessage(..))")
    public void sendMethodPointCut() {
    }

    @Around("sendMethodPointCut() && @annotation(com.nhnacademy.message_sender.annotation.HelloWorld) && args(user,..)")
    public void advice(ProceedingJoinPoint proceedingJoinPoint, User user) throws Throwable {
        System.out.println("Hello, World!");
        proceedingJoinPoint.proceed(new Object[]{user, "당신은 해킹당했읍니다"});
        System.out.println(user.getPhoneNumber());
    }
}
