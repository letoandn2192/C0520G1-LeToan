package bo.employee_bo;

import model.Employee;

import java.util.List;

public interface EmployeeBO {
    List<Employee> findAllEmployee();

    Employee findEmployeeById(String id);

    boolean editEmployeeInfo(Employee employee);

    boolean deleteEmployee(String id);

    void create(Employee employee);

    List<Employee> search(String search);

    List<Employee> getEmployeeByPage(int start, int offset);

    int getCountEmployee();

    List<String> checkValidateEmployee(String id, String idNumber, String salary, String phone, String email);

    List<String> checkValidateEmployee(String idNumber, String salary, String phone, String email);
}
