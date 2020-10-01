package vn.codegym.service;

import vn.codegym.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findOne(int id);

    void save(Province province);

    void remove(int id);
}
