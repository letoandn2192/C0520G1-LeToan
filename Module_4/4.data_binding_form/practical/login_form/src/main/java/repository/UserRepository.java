package repository;

import model.Login;
import model.User;

public interface UserRepository {
    User checkLogin(Login login);
}
