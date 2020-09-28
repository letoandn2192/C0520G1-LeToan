package vn.codegym.product_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.product_manager.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
