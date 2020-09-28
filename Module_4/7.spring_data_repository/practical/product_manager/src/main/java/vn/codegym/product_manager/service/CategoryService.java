package vn.codegym.product_manager.service;

import vn.codegym.product_manager.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();

    void saveAndUpdate(Category category);

    Category findById(long id);

    void delete(long id);
}
