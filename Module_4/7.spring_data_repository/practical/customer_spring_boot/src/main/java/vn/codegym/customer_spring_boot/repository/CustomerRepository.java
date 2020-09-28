package vn.codegym.customer_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.customer_spring_boot.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
