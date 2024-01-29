package com.nhnacademy.aiot.studentmanager.servlet;

import com.nhnacademy.aiot.studentmanager.domain.Gender;
import com.nhnacademy.aiot.studentmanager.domain.Student;
import com.nhnacademy.aiot.studentmanager.repository.StudentRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/student/register")
public class StudentRegisterServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getParameter("name");
        Student student = Student.builder()
                .id(req.getParameter("id"))
                .name(req.getParameter("name"))
                .gender(Gender.valueOf(req.getParameter("gender").toUpperCase()))
                .age(Integer.parseInt(req.getParameter("age")))
                .createdAt(LocalDateTime.now())
                .build();
        studentRepository.save(student);
        resp.sendRedirect("/student/list");
    }
}
