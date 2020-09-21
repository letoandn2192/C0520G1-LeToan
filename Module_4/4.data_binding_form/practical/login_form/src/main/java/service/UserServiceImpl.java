package service;

import model.Login;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.UserRepository;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
