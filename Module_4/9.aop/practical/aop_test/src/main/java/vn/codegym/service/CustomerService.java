package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Customer;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findOne(int id);

    void save(Customer customer);

    void delete(int id);

    long size();
}
