package bo.cutomer_bo;

import dao.customer_dao.CustomerDAO;
import dao.customer_dao.CustomerDAOImpl;
import model.Customer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerBOImpl implements CustomerBO {
    public static final String REGEX_ID_CUSTOMER = "^(KH-\\d{4})$";
    public static final String REGEX_PHONE_NUMBER_CUSTOMER = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$";
    public static final String REGEX_EMAIL_CUSTOMER = "^(\\w{3,}@\\w+\\.\\w+)$";
    public static final String REGEX_CUSTOMER_ID_CARD = "^\\d{9}$";

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

    public boolean checkRegex(String regexPattern, String input){
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public boolean checkValidateCustomerId(String id) {
        return !customerDAO.checkCustomerIdExists(id) && checkRegex(REGEX_ID_CUSTOMER, id) ;
    }

    @Override
    public boolean checkValidateCustomerIdNumber(String idNumber) {
        return checkRegex(REGEX_CUSTOMER_ID_CARD, idNumber);
    }

    public boolean checkValidatePhoneNumber(String phone) {
        return checkRegex(REGEX_PHONE_NUMBER_CUSTOMER, phone);
    }

    public boolean checkValidateEmail(String email) {
        return checkRegex(REGEX_EMAIL_CUSTOMER, email);
    }
}
