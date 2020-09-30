package com.codegym.demo.service;

import com.codegym.demo.model.ClassName;
import com.codegym.demo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student getById();

    void save(Student student);
}
