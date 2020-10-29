package vn.codegym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.User;
import vn.codegym.repository.UserRepository;
import vn.codegym.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByUserName(String input) {
        return userRepository.findByUserName(input);
    }
}
