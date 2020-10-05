package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.User;
import vn.codegym.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Iterable<User> findAll() {
        return loginRepository.findAll();
    }

    @Override
    public void save(User user) {
        loginRepository.save(user);
    }

    @Override
    public User findById(int id) {
        return loginRepository.findById(id).orElse(null);
    }
}
