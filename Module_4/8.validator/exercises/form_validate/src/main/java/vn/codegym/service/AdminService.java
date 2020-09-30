package vn.codegym.service;

import vn.codegym.model.Admin;

public interface AdminService {
    Iterable<Admin> findAll();

    void save(Admin admin);
}
