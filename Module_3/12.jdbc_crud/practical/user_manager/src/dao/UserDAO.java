package dao;

import model.User;
import sun.nio.cs.US_ASCII;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void createUser(User user) throws SQLException;

    List<User> selectAllUser();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    User selectUserById(int id);

    List<User> search(String search, String searchBy);

    List<User> sortByName();
}
