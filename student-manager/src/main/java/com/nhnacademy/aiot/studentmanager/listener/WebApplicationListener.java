package com.nhnacademy.aiot.studentmanager.listener;

import com.nhnacademy.aiot.studentmanager.domain.Gender;
import com.nhnacademy.aiot.studentmanager.domain.Student;
import com.nhnacademy.aiot.studentmanager.repository.MapStudentRepository;
import com.nhnacademy.aiot.studentmanager.repository.StudentRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;
import java.util.Random;

@WebListener
public class WebApplicationListener implements ServletContextListener {
    private final Random random;

    public WebApplicationListener() {
        random = new Random();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        StudentRepository studentRepository = new MapStudentRepository();

        for (int i = 0; i < 10; i++) {
            Student student = Student.builder()
                    .id("student" + (i + 1))
                    .name("아카데미" + (i + 1))
                    .gender(i % 2 == 0 ? Gender.MALE : Gender.FEMALE)
                    .age(random.nextInt(10) + 10)
                    .createdAt(LocalDateTime.now())
                    .build();
            studentRepository.save(student);
        }

        servletContext.setAttribute("studentRepository", studentRepository);
    }
}
