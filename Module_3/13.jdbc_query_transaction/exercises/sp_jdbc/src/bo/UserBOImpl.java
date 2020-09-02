package bo;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = new UserDAOImpl();

    @Override
    public void createUser(User user) throws SQLException {
//        userDAO.createUser(user);
        userDAO.insertUser(user);
    }

    @Override
    public List<User> selectAllUser() {
        return userDAO.selectAllUser();
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userDAO.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userDAO.deleteUser(id);
    }

    @Override
    public User selectUserById(int id) {
        return userDAO.getUserById(id);
//        return userDAO.selectUserById(id);
    }
}
