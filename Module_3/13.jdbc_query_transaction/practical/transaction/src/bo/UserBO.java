package bo;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserBO {
    void createUser(User user) throws SQLException;

    List<User> selectAllUser();

    boolean updateUser(User user) throws SQLException;

    boolean deleteUser(int id) throws SQLException;

    User selectUserById(int id);

    void addUserTransaction (User user, int[] permissions);
}
