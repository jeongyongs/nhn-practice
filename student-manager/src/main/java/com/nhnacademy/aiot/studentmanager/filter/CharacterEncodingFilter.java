package com.nhnacademy.aiot.studentmanager.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter extends HttpFilter {

    public static final String DEFAULT_ENCODING = "UTF-8";

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(DEFAULT_ENCODING);
        res.setCharacterEncoding(DEFAULT_ENCODING);

        chain.doFilter(req, res);
    }
}
