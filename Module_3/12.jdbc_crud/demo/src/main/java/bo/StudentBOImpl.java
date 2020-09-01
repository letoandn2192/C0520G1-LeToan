package bo;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

import java.util.List;

public class StudentBOImpl implements StudentBO{
    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public boolean save(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public boolean validateId() {
        return false;
    }
}
