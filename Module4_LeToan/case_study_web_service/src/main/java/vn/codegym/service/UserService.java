package vn.codegym.service;

import vn.codegym.model.User;

public interface UserService {
    User findUserByUserName(String input);
}
