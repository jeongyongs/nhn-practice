package com.nhnacademy.aiot.studentmanager.servlet;

import com.nhnacademy.aiot.studentmanager.domain.Student;
import com.nhnacademy.aiot.studentmanager.repository.StudentRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/update")
public class StudentUpdateServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = studentRepository.getStudentById(req.getParameter("id"));
        req.setAttribute("student", student);
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }
}
