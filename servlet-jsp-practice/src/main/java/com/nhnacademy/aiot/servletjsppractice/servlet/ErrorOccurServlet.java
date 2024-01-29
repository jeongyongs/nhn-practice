package com.nhnacademy.aiot.servletjsppractice.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/occur")
public class ErrorOccurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println(getServletContext().getInitParameter("url"));
        resp.getWriter().println(getServletConfig().getInitParameter("url"));
        resp.getWriter().println(getInitParameter("url"));
//        resp.sendError(404);
//        throw new RuntimeException();
    }
}