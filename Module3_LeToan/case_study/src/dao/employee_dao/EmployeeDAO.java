package dao.employee_dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAllEmployee();

    Employee findEmployeeById(String id);

    boolean editEmployeeInfo(Employee employee);

    boolean deleteEmployee(String id);

    void create(Employee employee);

    List<Employee> search(String search);

    List<Employee> getEmployeeByPage(int start, int offset);

    int getCountEmployee();

    boolean checkEmployeeIdExists(String id);
}
