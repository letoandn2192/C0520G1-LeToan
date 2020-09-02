package bo;

import model.Customer;

import java.util.List;

public interface BO {
    List<Customer> findAllCustomer();

    Customer findCustomerById(int id);
}
