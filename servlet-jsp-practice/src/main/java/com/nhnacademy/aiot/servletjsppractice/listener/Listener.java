package com.nhnacademy.aiot.servletjsppractice.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Listener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session has been created!");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session has been created!");
    }
}
