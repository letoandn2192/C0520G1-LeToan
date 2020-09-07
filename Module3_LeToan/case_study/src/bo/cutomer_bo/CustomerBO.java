package bo.cutomer_bo;

import model.Customer;

import java.util.List;

public interface CustomerBO {
    List<Customer> findAllCustomer();

    Customer findCustomerById(String id);

    boolean editCustomerInfo(Customer customer);

    boolean deleteCustomer(String id);

    void create(Customer customer);

    List<Customer> search(String search);

    public List<Customer> getCustomerByPage(int start, int offset);

    int getCountCustomer();

    boolean checkValidateCustomerId(String id);

    boolean checkValidateCustomerIdNumber(String idNumber);

    boolean checkValidatePhoneNumber(String phone);

    boolean checkValidateEmail(String email);
}
