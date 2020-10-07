package vn.codegym.demo_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.demo_security.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserName(String accountName);
}
