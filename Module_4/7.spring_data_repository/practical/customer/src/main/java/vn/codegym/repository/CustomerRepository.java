package vn.codegym.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.codegym.model.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
}
