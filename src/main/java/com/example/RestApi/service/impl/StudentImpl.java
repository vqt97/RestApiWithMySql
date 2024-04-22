package com.example.RestApi.service.impl;

import com.example.RestApi.exception.StudentNotFoundException;
import com.example.RestApi.model.Student;
import com.example.RestApi.repository.StudentRepository;
import com.example.RestApi.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService {
    StudentRepository studentRepository;

    public StudentImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        if (studentRepository.findById(id).isEmpty())
            throw new StudentNotFoundException("Requested Student does not exist", new Throwable().getCause());
        return studentRepository.findById(id).get();
    }

    @Override
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "Student added successfully";
    }

    @Override
    public String updateStudent(Student student) {
        studentRepository.save(student);
        return "Student updated successfully";
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }


}
