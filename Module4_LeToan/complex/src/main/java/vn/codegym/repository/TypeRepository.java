package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
