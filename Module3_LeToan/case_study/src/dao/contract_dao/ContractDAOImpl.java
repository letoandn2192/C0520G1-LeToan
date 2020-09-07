package dao.contract_dao;

import dao.DBConnection;
import model.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDAOImpl implements ContractDAO {
    private static final String SELECT_ALL_CONTRACT = "SELECT * FROM contract;";
    private static final String SELECT_CONTRACT_BY_ID = "SELECT * FROM contract WHERE contract_id = ?;";
    private static final String EDIT_CONTRACT_INFO = "UPDATE contract SET contract_start_date = ?, contract_end_date = ?, " +
            "contract_deposit = ?, contract_total_money = ?, employee_id = ?, customer_id = ?, service_id = ? " +
            "WHERE contract_id = ?;";
    private static final String DELETE_CONTRACT_BY_ID = "DELETE FROM contract WHERE contract_id = ?;";
    private static final String CREATE_NEW_CONTRACT = "INSERT INTO contract (contract_start_date, contract_end_date, " +
            "contract_deposit, contract_total_money, employee_id, customer_id, service_id) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String SEARCH_CONTRACT = "SELECT * FROM contract WHERE contract_id LIKE ?;";
    private static final String SELECT_CONTRACT_IN_PAGE = "SELECT * FROM contract LIMIT ?,?;";
    private static final String SELECT_COUNT_CONTRACT = "SELECT count(contract_id) FROM contract;";

    @Override
    public List<Contract> findAllContract() {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("contract_id");
                    Date startDate = resultSet.getDate("contract_start_date");
                    Date endDate = resultSet.getDate("contract_end_date");
                    double deposit = resultSet.getDouble("contract_deposit");
                    double totalMoney = resultSet.getDouble("contract_total_money");
                    String employeeId = resultSet.getString("employee_id");
                    String customerId = resultSet.getString("customer_id");
                    String serviceId = resultSet.getString("service_id");
                    contractList.add(new Contract(id, startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId));
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
        return contractList;
    }

    @Override
    public Contract findContractById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Contract contract = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_CONTRACT_BY_ID);
                preparedStatement.setInt(1, id );
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Date startDate = resultSet.getDate("contract_start_date");
                    Date endDate = resultSet.getDate("contract_end_date");
                    double deposit = resultSet.getDouble("contract_deposit");
                    double totalMoney = resultSet.getDouble("contract_total_money");
                    String employeeId = resultSet.getString("employee_id");
                    String customerId = resultSet.getString("customer_id");
                    String serviceId = resultSet.getString("service_id");
                    contract = new Contract(id, startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId);
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
        return contract;
    }

    @Override
    public void create(Contract contract) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(CREATE_NEW_CONTRACT);
                preparedStatement.setDate(1, contract.getContractStartDate());
                preparedStatement.setDate(2, contract.getContractEndDate());
                preparedStatement.setDouble(3, contract.getContractDeposit());
                preparedStatement.setDouble(4, contract.getContractTotalMoney());
                preparedStatement.setString(5, contract.getEmployeeId());
                preparedStatement.setString(6, contract.getCustomerId());
                preparedStatement.setString(7, contract.getServiceId());
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
    public boolean editContractInfo(Contract contract) {
        boolean rowEdit = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(EDIT_CONTRACT_INFO);
                preparedStatement.setInt(8, contract.getContractId());
                preparedStatement.setDate(1, contract.getContractStartDate());
                preparedStatement.setDate(2, contract.getContractEndDate());
                preparedStatement.setDouble(3, contract.getContractDeposit());
                preparedStatement.setDouble(4, contract.getContractTotalMoney());
                preparedStatement.setString(5, contract.getEmployeeId());
                preparedStatement.setString(6, contract.getCustomerId());
                preparedStatement.setString(7, contract.getServiceId());
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
    public boolean deleteContract(int id) {
        boolean rowDelete = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_CONTRACT_BY_ID);
                preparedStatement.setInt(1, id);
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
    public List<Contract> search(String search) {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SEARCH_CONTRACT);
                preparedStatement.setString(1, "%" + search + "%");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("contract_id");
                    Date startDate = resultSet.getDate("contract_start_date");
                    Date endDate = resultSet.getDate("contract_end_date");
                    double deposit = resultSet.getDouble("contract_deposit");
                    double totalMoney = resultSet.getDouble("contract_total_money");
                    String employeeId = resultSet.getString("employee_id");
                    String customerId = resultSet.getString("customer_id");
                    String serviceId = resultSet.getString("service_id");
                    contractList.add(new Contract(id, startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId));
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
        return contractList;
    }

    @Override
    public List<Contract> getContractByPage(int start, int offset) {
        List<Contract> subList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_CONTRACT_IN_PAGE);
                preparedStatement.setInt(1, start);
                preparedStatement.setInt(2, offset);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("contract_id");
                    Date startDate = resultSet.getDate("contract_start_date");
                    Date endDate = resultSet.getDate("contract_end_date");
                    double deposit = resultSet.getDouble("contract_deposit");
                    double totalMoney = resultSet.getDouble("contract_total_money");
                    String employeeId = resultSet.getString("employee_id");
                    String customerId = resultSet.getString("customer_id");
                    String serviceId = resultSet.getString("service_id");
                    subList.add(new Contract(id, startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId));
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
    public int getCountContract() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_COUNT_CONTRACT);
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
