package vn.codegym.product_manager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.product_manager.model.Product;

import java.util.List;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Iterable<Product> findAll();

    void saveAndUpdate(Product product);

    Product findById(long id);

    void delete(long id);

    void deleteProductInBatch(List<Long> idList);

    Page<Product> searchByName(String name, Pageable pageable);
}
