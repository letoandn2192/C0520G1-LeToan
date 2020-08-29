package bo;

import model.Product;

import java.util.List;

public interface ProductBO {
    List<Product> findAll();

    void create(Product product);

    void update(int id, Product product);

    void delete(int id);

    Product findById(int id);
}
