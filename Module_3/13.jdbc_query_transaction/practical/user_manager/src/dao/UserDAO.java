package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void createUser(User user) throws SQLException;

    List<User> selectAllUser();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    User selectUserById(int id);

    void insertUser(User user) throws SQLException;

    User getUserById(int id);
}
