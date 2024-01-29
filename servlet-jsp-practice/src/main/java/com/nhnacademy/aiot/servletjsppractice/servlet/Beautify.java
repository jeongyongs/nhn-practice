package com.nhnacademy.aiot.servletjsppractice.servlet;

import org.jsoup.Jsoup;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/beautify")
public class Beautify extends HttpServlet {
    @Override
    public void init() {
        System.out.println("init");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain");

        PrintWriter out = resp.getWriter();
        out.println(Jsoup.parse(req.getParameter("input")));
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
