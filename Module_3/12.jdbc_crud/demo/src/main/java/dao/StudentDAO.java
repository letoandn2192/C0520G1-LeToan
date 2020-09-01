package dao;

import model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();

    boolean save(Student student);

    Student findById(int id);

}
