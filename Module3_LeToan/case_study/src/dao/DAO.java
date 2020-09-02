package dao;

import model.Customer;

import java.util.List;

public interface DAO {
    List<Customer> findAllCustomer();

    Customer findCustomerById(int id);
}
