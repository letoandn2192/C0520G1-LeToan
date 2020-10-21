package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
