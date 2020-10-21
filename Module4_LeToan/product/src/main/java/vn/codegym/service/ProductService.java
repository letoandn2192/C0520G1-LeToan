package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import vn.codegym.model.Product;

import java.util.List;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    List<Product> findAll();

    Product findById(long id);

    void save(Product product);

    void delete(long id);

    Page<Product> findProductColorOrName(String input, Pageable pageable);

    Page<Product> findById(long id, Pageable pageable);

    Page<Product> findByName(String name, Pageable pageable);

    Page<Product> findByQuantity(long quantity, Pageable pageable);

    Page<Product> findByColor(String color, Pageable pageable);

    Page<Product> findByCategoryName(String name, Pageable pageable);

    List<Product> findAllSort(Sort sort);
}
