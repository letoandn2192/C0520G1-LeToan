package service;

import model.Login;
import model.User;

public interface UserService {
    User checkLogin(Login login);
}
