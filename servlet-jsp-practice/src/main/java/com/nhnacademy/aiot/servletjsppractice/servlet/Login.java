package com.nhnacademy.aiot.servletjsppractice.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
        req.getSession().setAttribute("fd", "fd");

        String userId = req.getParameter("userId");
        String userPw = req.getParameter("userPw");

        if (!userId.equals(getServletContext().getInitParameter("id"))
                || !userPw.equals(getServletContext().getInitParameter("pw"))) {
            req.getRequestDispatcher("/login.html").forward(req, resp);
            return;
        }
        out.println("login success");
    }
}
