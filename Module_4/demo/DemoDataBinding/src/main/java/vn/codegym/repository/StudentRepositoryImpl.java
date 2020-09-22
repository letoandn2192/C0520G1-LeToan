package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static  Map<Integer, Student> studentList;

    static {
        studentList = new HashMap<>();
        studentList.put(1, new Student(1, "Le Nhat", "Da Nang",15,"Male",new String[]{"PHP"}));
        studentList.put(2, new Student(2, "Le Toan", "Da Nang",15,"Male",new String[]{"JAVA"}));
        studentList.put(3, new Student(3, "Nguyen Tien Hai", "Da Nang",15,"Male",new String[]{"JAVA"}));
        studentList.put(4, new Student(4, "Nguyen Huu Quang", "Da Nang",15,"Male",new String[]{"JAVA"}));
        studentList.put(5, new Student(5, "Phan Quoc Khanh", "Da Nang",15,"Male",new String[]{"JAVA"}));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentList.values());
    }

    @Override
    public void save(Student student) {
        studentList.put(student.getId(),student);
    }

    @Override
    public Student findById(int id) {
        return studentList.get(id);
    }

    @Override
    public void update(int id, Student student) {
        studentList.put(id, student);
    }

    @Override
    public void remove(int id) {
        studentList.remove(id);
    }
}
