package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.User;

public interface LoginRepository extends JpaRepository<User, Integer> {
}
