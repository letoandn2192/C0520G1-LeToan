package vn.codegym.repository;

import vn.codegym.model.Product;

import java.util.List;

public interface ProductRepository {
    List<String> getProductType();

    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}
