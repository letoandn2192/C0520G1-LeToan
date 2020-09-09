package dao.login_dao;

import model.User;

public interface LoginDAO {
    User findUser(String userName, String pass);
}
