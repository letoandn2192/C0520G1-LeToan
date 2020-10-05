package vn.codegym.service;

import vn.codegym.model.Product;

public interface ProductService {
    Iterable<Product> findAll();

    Product findById(long id);

    void save(Product product);

    void delete(long id);
}
