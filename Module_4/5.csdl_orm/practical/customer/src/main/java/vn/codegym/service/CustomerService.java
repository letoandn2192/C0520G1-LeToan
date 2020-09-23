package vn.codegym.service;

import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findOne(Long id);

    void save(Customer customer);

    void delete(Long id);
}
