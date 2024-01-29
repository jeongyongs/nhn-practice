package com.nhnacademy.aiot.servletjsppractice.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(value = "/form")
public class Form extends HttpServlet {
    @Override
    public void init() {
        System.out.println("init");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        req.getParameterMap()
                .entrySet()
                .stream()
                .filter(e -> e.getValue()[0].equals("on"))
                .map(Map.Entry::getKey)
                .forEach(out::println);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
