package com.nhnacademy.edu.springframework.messagesender.aspect;

import com.nhnacademy.edu.springframework.messagesender.domain.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(* com.nhnacademy.edu.springframework.messagesender.sender.MessageSender.sendMessage(..))")
    public void sendMessagePointCut() {
    }

    @Around("sendMessagePointCut() && args(user, ..)")
    public Object logging(ProceedingJoinPoint proceedingJoinPoint, User user) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        try {
            stopWatch.start();
            System.out.println(user);
            return proceedingJoinPoint.proceed(new Object[]{new User("EMAIL", "PHONE"), "TE"});
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }
}
