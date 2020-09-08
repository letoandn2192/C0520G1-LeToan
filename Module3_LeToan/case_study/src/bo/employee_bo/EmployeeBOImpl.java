package bo.employee_bo;

import bo.common_bo.Regex;
import dao.employee_dao.EmployeeDAO;
import dao.employee_dao.EmployeeDAOImpl;
import model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeBOImpl implements EmployeeBO{
    public static final String REGEX_ID_EMPLOYEE = "^(NV-\\d{4})$";

    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    private boolean checkValidateEmployeeId(String id) {
        return !employeeDAO.checkEmployeeIdExists(id) && Regex.checkRegex(REGEX_ID_EMPLOYEE, id) ;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeDAO.findAllEmployee();
    }

    @Override
    public Employee findEmployeeById(String id) {
        return employeeDAO.findEmployeeById(id);
    }

    @Override
    public boolean editEmployeeInfo(Employee employee) {
        return employeeDAO.editEmployeeInfo(employee);
    }

    @Override
    public boolean deleteEmployee(String id) {
        return employeeDAO.deleteEmployee(id);
    }

    @Override
    public void create(Employee employee) {
        employeeDAO.create(employee);
    }

    @Override
    public List<Employee> search(String search) {
        return employeeDAO.search(search);
    }

    @Override
    public List<Employee> getEmployeeByPage(int start, int offset) {
        return employeeDAO.getEmployeeByPage(start, offset);
    }

    @Override
    public int getCountEmployee() {
        return employeeDAO.getCountEmployee();
    }

    @Override
    public List<String> checkValidateEmployee(String id, String idNumber, String salary, String phone, String email) {
        List<String> errMessList = new ArrayList<>();
        boolean checkValidateId = checkValidateEmployeeId(id);
        boolean checkValidateIdNumber = Regex.checkRegexIdNumber(idNumber);
        boolean checkValidateSalary = Regex.checkRegexDoublePositive(salary);
        boolean checkValidatePhone = Regex.checkRegexPhoneNumber(phone);
        boolean checkValidateEmail = Regex.checkRegexEmail(email);
        if (!(checkValidateId && checkValidateIdNumber && checkValidateEmail && checkValidatePhone && checkValidateSalary)) {
            if (!checkValidateId) {
                errMessList.add( "Customer ID format NV-XXXX (X from 0-9)");
            } else {
                errMessList.add("");
            }
            if (!checkValidateIdNumber) {
                errMessList.add( "Id Card format XXXXXXXXX (X from 0-9)");
            } else {
                errMessList.add("");
            }
            if (!checkValidateSalary) {
                errMessList.add( "Salary must be positive number");
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

    @Override
    public List<String> checkValidateEmployee(String idNumber, String salary, String phone, String email) {
        List<String> errMessList = new ArrayList<>();
        boolean checkValidateIdNumber = Regex.checkRegexIdNumber(idNumber);
        boolean checkValidateSalary = Regex.checkRegexDoublePositive(salary);
        boolean checkValidatePhone = Regex.checkRegexPhoneNumber(phone);
        boolean checkValidateEmail = Regex.checkRegexEmail(email);
        if (!(checkValidateIdNumber && checkValidateEmail && checkValidatePhone && checkValidateSalary)) {
            if (!checkValidateIdNumber) {
                errMessList.add( "Id Card format XXXXXXXXX (X from 0-9)");
            } else {
                errMessList.add("");
            }
            if (!checkValidateSalary) {
                errMessList.add( "Salary must be positive number");
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
