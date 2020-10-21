package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
