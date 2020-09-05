package dao.customer_dao;

import dao.DBConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private static final String SELECT_ALL_CUSTOMER = "SELECT * FROM customer;";
    private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customer WHERE customer_id = ?;";
    private static final String EDIT_CUSTOMER_INFO = "UPDATE customer SET customer_type_id = ?, customer_name = ?, customer_birthday = ?, " +
            "customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ? WHERE customer_id = ?;";
    private static final String DELETE_CUSTOMER_BY_ID = "DELETE FROM customer WHERE customer_id = ?;";
    private static final String CREATE_NEW_CUSTOMER = "INSERT INTO customer (customer_id, customer_type_id, customer_name, customer_birthday, " +
            "customer_gender, customer_id_card, customer_phone, customer_email, customer_address) VALUES" +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SEARCH_CUSTOMER = "SELECT * FROM customer WHERE customer_id LIKE ?" +
            "OR customer_name LIKE ?;";
    private static final String SELECT_CUSTOMER_IN_PAGE = "SELECT * FROM customer LIMIT ?,?;";
    private static final String SELECT_COUNT_CUSTOMER = "SELECT count(customer_id) FROM customer;";

    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("customer_id");
                    String name = resultSet.getString("customer_name");
                    Date birthday = resultSet.getDate("customer_birthday");
                    int gender = resultSet.getInt("customer_gender");
                    String idCard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    int typeCustomerId = resultSet.getInt("customer_type_id");
                    customerList.add(new Customer(id, name, birthday, gender, idCard, phone, email, address, typeCustomerId));
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
        return customerList;
    }

    @Override
    public Customer findCustomerById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
                preparedStatement.setString(1, id );
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int customerType = resultSet.getInt("customer_type_id");
                    String name = resultSet.getString("customer_name");
                    Date birthday = resultSet.getDate("customer_birthday");
                    int gender = resultSet.getInt("customer_gender");
                    String idNumber = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    customer = new Customer(id, name, birthday, gender, idNumber, phone, email, address, customerType);
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
        return customer;
    }

    @Override
    public boolean editCustomerInfo(Customer customer) {
        boolean rowEdit = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(EDIT_CUSTOMER_INFO);
                preparedStatement.setString(9, customer.getCustomerId());
                preparedStatement.setInt(1, customer.getCustomerTypeId());
                preparedStatement.setString(2, customer.getCustomerName());
                preparedStatement.setDate(3, customer.getCustomerBirthday());
                preparedStatement.setInt(4, customer.getCustomerGender());
                preparedStatement.setString(5, customer.getCustomerIdCard());
                preparedStatement.setString(6, customer.getCustomerPhone());
                preparedStatement.setString(7, customer.getCustomerEmail());
                preparedStatement.setString(8, customer.getCustomerAddress());
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
    public boolean deleteCustomer(String id) {
        boolean rowDelete = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
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
    public void create(Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(CREATE_NEW_CUSTOMER);
                preparedStatement.setString(1, customer.getCustomerId());
                preparedStatement.setInt(2, customer.getCustomerTypeId());
                preparedStatement.setString(3, customer.getCustomerName());
                preparedStatement.setDate(4, customer.getCustomerBirthday());
                preparedStatement.setInt(5, customer.getCustomerGender());
                preparedStatement.setString(6, customer.getCustomerIdCard());
                preparedStatement.setString(7, customer.getCustomerPhone());
                preparedStatement.setString(8, customer.getCustomerEmail());
                preparedStatement.setString(9, customer.getCustomerAddress());
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
    public List<Customer> search(String search) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER);
                preparedStatement.setString(1, "%" + search + "%");
                preparedStatement.setString(2, "%" + search + "%");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("customer_id");
                    String name = resultSet.getString("customer_name");
                    Date birthday = resultSet.getDate("customer_birthday");
                    int gender = resultSet.getInt("customer_gender");
                    String idCard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    int typeCustomerId = resultSet.getInt("customer_type_id");
                    customerList.add(new Customer(id, name, birthday, gender, idCard, phone, email, address, typeCustomerId));
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
        return customerList;
    }

    @Override
    public List<Customer> getCustomerByPage(int start, int offset) {
        List<Customer> subList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_IN_PAGE);
                preparedStatement.setInt(1, start);
                preparedStatement.setInt(2, offset);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("customer_id");
                    String name = resultSet.getString("customer_name");
                    Date birthday = resultSet.getDate("customer_birthday");
                    int gender = resultSet.getInt("customer_gender");
                    String idCard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    int typeCustomerId = resultSet.getInt("customer_type_id");
                    subList.add(new Customer(id, name, birthday, gender, idCard, phone, email, address, typeCustomerId));
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
    public int getCountCustomer() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_COUNT_CUSTOMER);
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
