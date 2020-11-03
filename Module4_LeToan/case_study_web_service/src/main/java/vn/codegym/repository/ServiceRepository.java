package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Services;

public interface ServiceRepository extends JpaRepository<Services, Long> {
//    Page<Services> findServiceByServiceIdContainingOrServiceNameContaining (String id, String name, Pageable pageable);
}
