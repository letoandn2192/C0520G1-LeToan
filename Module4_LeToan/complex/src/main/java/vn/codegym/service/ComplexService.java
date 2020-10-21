package vn.codegym.service;

import vn.codegym.model.Complex;

import java.util.List;

public interface ComplexService {
    List<Complex> findAll();

    List<Complex> findAllSortFloorDesc();

    Complex findById(String id);

    void save(Complex complex);

    void deleteById(String id);
}
