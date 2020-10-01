package vn.codegym.service;

import vn.codegym.model.RandomCode;

public interface RandomCodeService {
    Iterable<RandomCode> findAll();

    RandomCode findById(int id);

    void save(RandomCode code);

    void delete(int id);

    RandomCode findByBookAndCode(int bookId, int code);
}
