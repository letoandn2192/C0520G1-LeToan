package vn.codegym.service;

import vn.codegym.model.Student;

import java.util.List;

public interface StudentService {
    Iterable<Student> findAll();

    void save(Student student);

    Student findById(long id);

    List<Student> findStudentIdIsIn (List<Long> idList);
}
