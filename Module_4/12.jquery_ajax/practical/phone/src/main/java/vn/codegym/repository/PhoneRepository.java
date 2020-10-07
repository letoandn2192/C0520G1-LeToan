package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
