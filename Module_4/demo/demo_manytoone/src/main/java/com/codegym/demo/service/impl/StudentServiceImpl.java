package com.codegym.demo.service.impl;

import com.codegym.demo.model.Student;
import com.codegym.demo.repository.StudentRepository;
import com.codegym.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById() {
        return null;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
}
