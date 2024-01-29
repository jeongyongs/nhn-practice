package com.nhnacademy.aiot.servletjsppractice.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/*")
public class AuthFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        if (req.getRequestURI().equals("/logina")) {
//            req.getRequestDispatcher("/index.html").forward(req, res);
//            return;
//        }
        chain.doFilter(req, res);
    }
}
