package vn.codegym.repository;

import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findOne(Long id);

    void save(Customer customer);

    void delete(Long id);
}
