package bo.cutomer_bo;

import bo.common_bo.Regex;
import dao.customer_dao.CustomerDAO;
import dao.customer_dao.CustomerDAOImpl;
import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    public static final String REGEX_ID_CUSTOMER = "^(KH-\\d{4})$";
    CustomerDAO customerDAO = new CustomerDAOImpl();

    private boolean checkValidateCustomerId(String id) {
        return !customerDAO.checkCustomerIdExists(id) && Regex.checkRegex(REGEX_ID_CUSTOMER, id) ;
    }

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

    @Override
    public List<String> checkValidateCustomer(String id, String idNumber, String phone, String email) {
        List<String> errMessList = new ArrayList<>(4);
        boolean checkValidateId = checkValidateCustomerId(id);
        boolean checkValidateIdNumber = Regex.checkRegexIdNumber(idNumber);
        boolean checkValidatePhone = Regex.checkRegexPhoneNumber(phone);
        boolean checkValidateEmail = Regex.checkRegexEmail(email);
        if (!(checkValidateId && checkValidateIdNumber && checkValidateEmail && checkValidatePhone)) {
            if (!checkValidateId) {
                errMessList.add( "Customer ID format KH-XXXX (X from 0-9)");
            } else {
                errMessList.add("");
            }
            if (!checkValidateIdNumber) {
                errMessList.add( "Id Card format XXXXXXXXX (X from 0-9)");
            } else {
                errMessList.add("");
            }
            if (!checkValidatePhone) {
                errMessList.add( "Phone number format ...");
            } else {
                errMessList.add("");
            }
            if (!checkValidateEmail) {
                errMessList.add( "Email format abc@abc.abc");
            } else {
                errMessList.add("");
            }
        }
        return errMessList;
    }

    public List<String> checkValidateCustomer(String idNumber, String phone, String email) {
        List<String> errMessList = new ArrayList<>(3);
        boolean checkValidateIdNumber = Regex.checkRegexIdNumber(idNumber);
        boolean checkValidatePhone = Regex.checkRegexPhoneNumber(phone);
        boolean checkValidateEmail = Regex.checkRegexEmail(email);
        if (!(checkValidateIdNumber && checkValidateEmail && checkValidatePhone)) {
            if (!checkValidateIdNumber) {
                errMessList.add( "Id Card format XXXXXXXXX (X from 0-9)");
            } else {
                errMessList.add("");
            }
            if (!checkValidatePhone) {
                errMessList.add( "Phone number format ...");
            } else {
                errMessList.add("");
            }
            if (!checkValidateEmail) {
                errMessList.add( "Email format abc@abc.abc");
            } else {
                errMessList.add("");
            }
        }
        return errMessList;
    }
}
