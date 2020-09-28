package vn.codegym.product_manager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.product_manager.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByProductNameContaining(String name, Pageable pageable);

    void deleteProductsByProductIdIn(List<Long> idList);

    void deleteProductsByProductId(long id);
}
