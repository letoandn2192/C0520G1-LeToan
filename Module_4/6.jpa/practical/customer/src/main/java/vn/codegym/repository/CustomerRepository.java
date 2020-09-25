package vn.codegym.repository;

import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findOne(int id);

    void save(Customer customer);

    void edit(Customer customer);

    void delete(int id);
}
