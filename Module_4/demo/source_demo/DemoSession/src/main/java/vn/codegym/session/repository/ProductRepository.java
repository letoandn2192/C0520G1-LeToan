package vn.codegym.session.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.session.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
