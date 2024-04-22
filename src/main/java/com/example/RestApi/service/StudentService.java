package com.example.RestApi.service;

import com.example.RestApi.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();
    public Student getStudentById(int id);
    public String addStudent(Student student);
    public String updateStudent(Student student);
    public void deleteStudent(int id);
}
