package vn.codegym.demo_jpa_repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.demo_jpa_repository.model.Student;
import vn.codegym.demo_jpa_repository.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return  studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void remove(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findByNameAndAddress(String name) {
        return  studentRepository.findByName(name);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }


}
