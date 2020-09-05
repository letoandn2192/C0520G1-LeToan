package bo.employee_bo;

import dao.employee_dao.EmployeeDAO;
import dao.employee_dao.EmployeeDAOImpl;
import model.Employee;

import java.util.List;

public class EmployeeBOImpl implements EmployeeBO{
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();
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
}
