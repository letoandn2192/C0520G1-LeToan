package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.RentType;

public interface RentTypeRepository extends JpaRepository<RentType, Long> {
}
