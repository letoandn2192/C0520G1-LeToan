package vn.codegym.service;

import vn.codegym.model.User;

public interface UserService {
    Iterable<User> findAll();

    void save(User user);
}
