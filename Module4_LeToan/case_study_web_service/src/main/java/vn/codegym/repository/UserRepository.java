package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Role;
import vn.codegym.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserName (String userName);
}
