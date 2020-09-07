package dao.customer_dao;

import model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> findAllCustomer();

    Customer findCustomerById(String id);

    boolean editCustomerInfo(Customer customer);

    boolean deleteCustomer(String id);

    void create(Customer customer);

    List<Customer> search(String search);

    List<Customer> getCustomerByPage(int start, int offset);

    int getCountCustomer();

    boolean checkCustomerIdExists(String id);
}
