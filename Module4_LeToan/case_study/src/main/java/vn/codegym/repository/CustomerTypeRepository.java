package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.CustomerType;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
