package com.nhnacademy.message_sender.aspect;

import com.nhnacademy.message_sender.domain.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

class HelloWorldAspectTest {
    @Mock
    User user;
    @Mock
    ProceedingJoinPoint proceedingJoinPoint;
    HelloWorldAspect helloWorldAspect;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.initMocks(this);
        helloWorldAspect = new HelloWorldAspect();
    }

    @Test
    void advice() throws Throwable {
        // given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        String phoneNumber = "010-0000-0000";
        String message = "당신은 해킹당했읍니다";

        when(user.getPhoneNumber()).thenReturn(phoneNumber);
        when(proceedingJoinPoint.proceed(any())).thenAnswer(ans -> {
            System.out.println(message);
            return ans;
        });

        // when
        helloWorldAspect.advice(proceedingJoinPoint, user);

        // then
        Assertions.assertEquals("Hello, World!\n" + message + "\n" + phoneNumber, byteArrayOutputStream.toString().trim());
    }
}