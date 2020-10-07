package vn.codegym.service;

import vn.codegym.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();

    void saveAndUpdate(Category category);

    Category findById(int id);

    void delete(int id);
}
