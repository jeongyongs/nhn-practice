package com.nhnacademy.aiot.servletjsppractice.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
    String ERROR_STATUS_CODE = "javax.servlet.error.status_code";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println(req.getAttribute(ERROR_STATUS_CODE));
    }
}
