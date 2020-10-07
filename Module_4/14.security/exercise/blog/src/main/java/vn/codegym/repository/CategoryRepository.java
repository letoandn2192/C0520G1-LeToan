package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
