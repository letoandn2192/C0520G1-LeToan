package bo.cutomer_bo;

import dao.customer_dao.CustomerDAO;
import dao.customer_dao.CustomerDAOImpl;
import model.Customer;

import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public List<Customer> findAllCustomer() {
        return customerDAO.findAllCustomer();
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerDAO.findCustomerById(id);
    }

    @Override
    public boolean editCustomerInfo(Customer customer) {
        return customerDAO.editCustomerInfo(customer);
    }

    @Override
    public boolean deleteCustomer(String id) {
        return customerDAO.deleteCustomer(id);
    }

    @Override
    public void create(Customer customer) {
        customerDAO.create(customer);
    }

    @Override
    public List<Customer> search(String search) {
        return customerDAO.search(search);
    }

    public List<Customer> getCustomerByPage(int start, int offset) { ;
        return customerDAO.getCustomerByPage(start, offset);
    }

    @Override
    public int getCountCustomer() {
        return customerDAO.getCountCustomer();
    }
}
