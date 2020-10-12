package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Customer;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByIdAndName(String inputSearch, Pageable pageable);

    Iterable<Customer> findAll();

    Customer findById(String id);

    void save(Customer customer);

    void delete(String id);
}
