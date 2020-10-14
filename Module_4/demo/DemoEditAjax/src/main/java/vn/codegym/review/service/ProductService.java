package vn.codegym.review.service;

import vn.codegym.review.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

}
