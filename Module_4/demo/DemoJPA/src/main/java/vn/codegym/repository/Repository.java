package vn.codegym.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    void save(T t);

    T findById(int id);

    void update(T t);

    void remove(int id);
}
