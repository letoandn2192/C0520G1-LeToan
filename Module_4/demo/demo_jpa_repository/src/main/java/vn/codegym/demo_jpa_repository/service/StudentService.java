package vn.codegym.demo_jpa_repository.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.demo_jpa_repository.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    void save(Student student);

    Student findById(int id);

    void update(Student student);

    void remove(int id);

    List<Student> findByNameAndAddress(String name);

    Page<Student> findAll(Pageable pageable);
}
