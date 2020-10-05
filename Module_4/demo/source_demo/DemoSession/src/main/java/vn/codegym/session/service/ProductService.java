package vn.codegym.session.service;

import vn.codegym.session.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

}
