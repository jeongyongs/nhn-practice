package com.nhnacademy.aiot.studentmanager.repository;

import com.nhnacademy.aiot.studentmanager.domain.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStudentRepository implements StudentRepository {
    private Map<String, Student> students;

    public MapStudentRepository() {
        students = new HashMap<>();
    }

    @Override

    public void save(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public void update(Student student) {
        save(student);
    }

    @Override
    public void deleteById(String id) {
        students.remove(id);
    }

    @Override
    public Student getStudentById(String id) {
        return students.get(id);
    }

    @Override
    public List<Student> getStudents() {
        return new ArrayList<>(students.values());
    }

    @Override
    public boolean existById(String id) {
        return students.containsKey(id);
    }
}
