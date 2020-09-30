package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
