package bo;

import dao.DAO;
import dao.DAOImpl;
import model.Customer;

import java.util.List;

public class BOImpl implements BO{
    DAO customerBO = new DAOImpl();
    @Override
    public List<Customer> findAllCustomer() {
        return customerBO.findAllCustomer();
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerBO.findCustomerById(id);
    }
}
