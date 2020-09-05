package dao.employee_dao;

import dao.DBConnection;
import model.Customer;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
    private static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee;";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE employee_id = ?;";
    private static final String EDIT_EMPLOYEE_INFO = "UPDATE employee SET employee_name = ?, employee_birthday = ?, employee_id_card = ?, " +
            "employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, " +
            "education_degree_id = ?, division_id = ?, username = ? WHERE employee_id = ?;";
    private static final String DELETE_EMPLOYEE_BY_ID = "DELETE FROM employee WHERE employee_id = ?;";
    private static final String CREATE_NEW_EMPLOYEE = "INSERT INTO employee (employee_id, employee_name, employee_birthday, employee_id_card, " +
            "employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username) " +
            "VALUES" + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SEARCH_EMPLOYEE = "SELECT * FROM employee WHERE employee_id LIKE ?" +
            "OR employee_name LIKE ?;";
    private static final String SELECT_EMPLOYEE_IN_PAGE = "SELECT * FROM employee LIMIT ?,?;";
    private static final String SELECT_COUNT_EMPLOYEE = "SELECT count(employee_id) FROM employee;";

    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("employee_id");
                    String name = resultSet.getString("employee_name");
                    Date birthday = resultSet.getDate("employee_birthday");
                    String idCard = resultSet.getString("employee_id_card");
                    double salary = resultSet.getDouble("employee_salary");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    int position = resultSet.getInt("position_id");
                    int education = resultSet.getInt("education_degree_id");
                    int division = resultSet.getInt("division_id");
                    String username = resultSet.getString("username");
                    employeeList.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, position, education, division, username));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return employeeList;
    }

    @Override
    public Employee findEmployeeById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
                preparedStatement.setString(1, id );
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("employee_name");
                    Date birthday = resultSet.getDate("employee_birthday");
                    String idCard = resultSet.getString("employee_id_card");
                    double salary = resultSet.getDouble("employee_salary");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    int position = resultSet.getInt("position_id");
                    int education = resultSet.getInt("education_degree_id");
                    int division = resultSet.getInt("division_id");
                    String username = resultSet.getString("username");
                    employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, education, division, username);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return employee;
    }

    @Override
    public boolean editEmployeeInfo(Employee employee) {
        boolean rowEdit = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(EDIT_EMPLOYEE_INFO);
                preparedStatement.setString(12, employee.getEmployeeId());
                preparedStatement.setString(1, employee.getEmployeeName());
                preparedStatement.setDate(2, employee.getEmployeeBirthday());
                preparedStatement.setString(3, employee.getEmployeeIdCard());
                preparedStatement.setDouble(4, employee.getEmployeeSalary());
                preparedStatement.setString(5, employee.getEmployeePhone());
                preparedStatement.setString(6, employee.getEmployeeEmail());
                preparedStatement.setString(7, employee.getEmployeeAddress());
                preparedStatement.setInt(8, employee.getPositionId());
                preparedStatement.setInt(9, employee.getEducationDegreeId());
                preparedStatement.setInt(10, employee.getDivisionId());
                preparedStatement.setString(11, employee.getUserName());
                rowEdit = preparedStatement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return rowEdit;
    }

    @Override
    public boolean deleteEmployee(String id) {
        boolean rowDelete = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);
                preparedStatement.setString(1, id);
                rowDelete = preparedStatement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return rowDelete;
    }

    @Override
    public void create(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(CREATE_NEW_EMPLOYEE);
                preparedStatement.setString(1, employee.getEmployeeId());
                preparedStatement.setString(2, employee.getEmployeeName());
                preparedStatement.setDate(3, employee.getEmployeeBirthday());
                preparedStatement.setString(4, employee.getEmployeeIdCard());
                preparedStatement.setDouble(5, employee.getEmployeeSalary());
                preparedStatement.setString(6, employee.getEmployeePhone());
                preparedStatement.setString(7, employee.getEmployeeEmail());
                preparedStatement.setString(8, employee.getEmployeeAddress());
                preparedStatement.setInt(9, employee.getPositionId());
                preparedStatement.setInt(10, employee.getEducationDegreeId());
                preparedStatement.setInt(11, employee.getDivisionId());
                preparedStatement.setString(12, employee.getUserName());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }

    }

    @Override
    public List<Employee> search(String search) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE);
                preparedStatement.setString(1, "%" + search + "%");
                preparedStatement.setString(2, "%" + search + "%");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("employee_id");
                    String name = resultSet.getString("employee_name");
                    Date birthday = resultSet.getDate("employee_birthday");
                    String idCard = resultSet.getString("employee_id_card");
                    double salary = resultSet.getDouble("employee_salary");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    int position = resultSet.getInt("position_id");
                    int education = resultSet.getInt("education_degree_id");
                    int division = resultSet.getInt("division_id");
                    String username = resultSet.getString("username");
                    employeeList.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, position, education, division, username));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return employeeList;

    }

    @Override
    public List<Employee> getEmployeeByPage(int start, int offset) {
        List<Employee> subList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_IN_PAGE);
                preparedStatement.setInt(1, start);
                preparedStatement.setInt(2, offset);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("employee_id");
                    String name = resultSet.getString("employee_name");
                    Date birthday = resultSet.getDate("employee_birthday");
                    String idCard = resultSet.getString("employee_id_card");
                    double salary = resultSet.getDouble("employee_salary");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    int position = resultSet.getInt("position_id");
                    int education = resultSet.getInt("education_degree_id");
                    int division = resultSet.getInt("division_id");
                    String username = resultSet.getString("username");
                    subList.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, position, education, division, username));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return subList;
    }

    @Override
    public int getCountEmployee() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_COUNT_EMPLOYEE);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return count;
    }
}
