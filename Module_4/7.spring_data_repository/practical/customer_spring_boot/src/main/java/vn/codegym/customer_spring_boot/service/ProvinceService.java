package vn.codegym.customer_spring_boot.service;

import vn.codegym.customer_spring_boot.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findOne(int id);

    void save(Province province);

    void remove(int id);
}
