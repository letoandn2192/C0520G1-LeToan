package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByAccountId(String account);
}
