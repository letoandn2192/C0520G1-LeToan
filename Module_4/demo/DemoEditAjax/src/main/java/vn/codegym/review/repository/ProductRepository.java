package vn.codegym.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.review.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
