package bo;

import model.Student;

import java.util.List;

public interface StudentBO {
    List<Student> findAll();

    boolean save(Student student);

    Student findById(int id);

    boolean validateId();
}
