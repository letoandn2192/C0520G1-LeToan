package vn.codegym.service;

import vn.codegym.model.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> findAll();

    Phone findById(long id);

    void save(Phone phone);

    void delete(long id);
}
