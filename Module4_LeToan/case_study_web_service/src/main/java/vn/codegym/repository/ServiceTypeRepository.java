package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
