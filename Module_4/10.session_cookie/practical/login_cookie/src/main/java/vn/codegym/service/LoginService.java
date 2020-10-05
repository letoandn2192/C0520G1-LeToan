package vn.codegym.service;

import vn.codegym.model.User;

public interface LoginService {
    Iterable<User> findAll();

    void save(User user);

    User findById(int id);
}
