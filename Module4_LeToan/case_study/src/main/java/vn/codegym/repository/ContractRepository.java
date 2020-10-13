package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Contract;
import vn.codegym.model.Customer;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
