package dao;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private static final String SELECT_All_STUDENT = "select * from student";

    @Override
    public List<Student> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Student> studentList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_All_STUDENT);
                resultSet = statement.executeQuery();
                Student student = null;
                while (resultSet.next()) {
                    student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setAddress(resultSet.getString("address"));
                    studentList.add(student);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return studentList;
    }

    @Override
    public boolean save(Student student) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        int count = 0;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into student(name, address) value (?,?);");
                statement.setString(1, student.getName());
                statement.setString(2, student.getAddress());
                count = statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        if (count != 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Student findById(int id) {
        return null;
    }
}
