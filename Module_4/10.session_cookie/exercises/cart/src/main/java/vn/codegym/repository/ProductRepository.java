package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
