package dao.service_dao;

import dao.DBConnection;
import model.Customer;
import model.Employee;
import model.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOImpl implements ServiceDAO {
    private static final String SELECT_ALL_SERVICE = "SELECT * FROM service;";
    private static final String SELECT_SERVICE_BY_ID = "SELECT * FROM service WHERE service_id = ?;";
    private static final String EDIT_SERVICE_INFO = "UPDATE service SET service_name = ?, service_area = ?, service_cost = ?, " +
            "service_max_person = ?, rent_type_id = ?, service_type_id = ?, standard_room = ?, description_other_convenience = ?, " +
            "pool_area = ?, number_of_floors = ? WHERE service_id = ?;";
    private static final String DELETE_SERVICE_BY_ID = "DELETE FROM service WHERE service_id = ?;";
    private static final String CREATE_NEW_SERVICE = "INSERT INTO service (service_id, service_name, service_area, service_cost, " +
            "service_max_person, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, " +
            "number_of_floors) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SEARCH_SERVICE = "SELECT * FROM service WHERE service_id LIKE ?" +
            "OR service_name LIKE ?;";
    private static final String SELECT_SERVICE_IN_PAGE = "SELECT * FROM service LIMIT ?,?;";
    private static final String SELECT_COUNT_SERVICE = "SELECT count(service_id) FROM service;";
    private static final String CHECK_SERVICE_ID_EXISTS = "SELECT 1 FROM service WHERE service_id = ?;";

    @Override
    public List<Service> findAllService() {
        List<Service> serviceList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("service_id");
                    String name = resultSet.getString("service_name");
                    double area = resultSet.getDouble("service_area");
                    double cost = resultSet.getDouble("service_cost");
                    int phone = resultSet.getInt("service_max_person");
                    int rentTypeId = resultSet.getInt("rent_type_id");
                    int serviceTypeId = resultSet.getInt("service_type_id");
                    String standardRoom = resultSet.getString("standard_room");
                    String description = resultSet.getString("description_other_convenience");
                    double poolArea = resultSet.getDouble("pool_area");
                    int floor = resultSet.getInt("number_of_floors");
                    serviceList.add(new Service(id, name, area, cost, phone, rentTypeId, serviceTypeId, standardRoom, description, poolArea, floor));
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
        return serviceList;
    }

    @Override
    public Service findServiceById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Service service = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);
                preparedStatement.setString(1, id );
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("service_name");
                    double area = resultSet.getDouble("service_area");
                    double cost = resultSet.getDouble("service_cost");
                    int phone = resultSet.getInt("service_max_person");
                    int rentTypeId = resultSet.getInt("rent_type_id");
                    int serviceTypeId = resultSet.getInt("service_type_id");
                    String standardRoom = resultSet.getString("standard_room");
                    String description = resultSet.getString("description_other_convenience");
                    double poolArea = resultSet.getDouble("pool_area");
                    int floor = resultSet.getInt("number_of_floors");
                    service = new Service(id, name, area, cost, phone, rentTypeId, serviceTypeId, standardRoom, description, poolArea, floor);
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
        return service;
    }

    @Override
    public void create(Service service) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(CREATE_NEW_SERVICE);
                preparedStatement.setString(1, service.getServiceId());
                preparedStatement.setString(2, service.getServiceName());
                preparedStatement.setDouble(3, service.getServiceArea());
                preparedStatement.setDouble(4, service.getServiceCost());
                preparedStatement.setInt(5, service.getServiceMaxPerson());
                preparedStatement.setInt(6, service.getRentTypeId());
                preparedStatement.setInt(7, service.getServiceTypeId());
                preparedStatement.setString(8, service.getStandardRoom());
                preparedStatement.setString(9, service.getDescription());
                preparedStatement.setDouble(10, service.getPoolArea());
                preparedStatement.setInt(11, service.getNumberFloor());
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
    public boolean editServiceInfo(Service service) {
        boolean rowEdit = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(EDIT_SERVICE_INFO);
                preparedStatement.setString(11, service.getServiceId());
                preparedStatement.setString(1, service.getServiceName());
                preparedStatement.setDouble(2, service.getServiceArea());
                preparedStatement.setDouble(3, service.getServiceCost());
                preparedStatement.setInt(4, service.getServiceMaxPerson());
                preparedStatement.setInt(5, service.getRentTypeId());
                preparedStatement.setInt(6, service.getServiceTypeId());
                preparedStatement.setString(7, service.getStandardRoom());
                preparedStatement.setString(8, service.getDescription());
                preparedStatement.setDouble(9, service.getPoolArea());
                preparedStatement.setInt(10, service.getNumberFloor());
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
    public boolean deleteService(String id) {
        boolean rowDelete = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_SERVICE_BY_ID);
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
    public List<Service> search(String search) {
        List<Service> serviceList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SEARCH_SERVICE);
                preparedStatement.setString(1, "%" + search + "%");
                preparedStatement.setString(2, "%" + search + "%");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("service_id");
                    String name = resultSet.getString("service_name");
                    double area = resultSet.getDouble("service_area");
                    double cost = resultSet.getDouble("service_cost");
                    int phone = resultSet.getInt("service_max_person");
                    int rentTypeId = resultSet.getInt("rent_type_id");
                    int serviceTypeId = resultSet.getInt("service_type_id");
                    String standardRoom = resultSet.getString("standard_room");
                    String description = resultSet.getString("description_other_convenience");
                    double poolArea = resultSet.getDouble("pool_area");
                    int floor = resultSet.getInt("number_of_floors");
                    serviceList.add(new Service(id, name, area, cost, phone, rentTypeId, serviceTypeId, standardRoom, description, poolArea, floor));
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
        return serviceList;
    }

    @Override
    public List<Service> getServiceByPage(int start, int offset) {
        List<Service> subList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_SERVICE_IN_PAGE);
                preparedStatement.setInt(1, start);
                preparedStatement.setInt(2, offset);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("service_id");
                    String name = resultSet.getString("service_name");
                    double area = resultSet.getDouble("service_area");
                    double cost = resultSet.getDouble("service_cost");
                    int phone = resultSet.getInt("service_max_person");
                    int rentTypeId = resultSet.getInt("rent_type_id");
                    int serviceTypeId = resultSet.getInt("service_type_id");
                    String standardRoom = resultSet.getString("standard_room");
                    String description = resultSet.getString("description_other_convenience");
                    double poolArea = resultSet.getDouble("pool_area");
                    int floor = resultSet.getInt("number_of_floors");
                    subList.add(new Service(id, name, area, cost, phone, rentTypeId, serviceTypeId, standardRoom, description, poolArea, floor));
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
    public int getCountService() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_COUNT_SERVICE);
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

    @Override
    public boolean checkServiceIdExists(String id) {
        boolean checkExists = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(CHECK_SERVICE_ID_EXISTS);
                preparedStatement.setString(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    checkExists = true;
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
        return checkExists;

    }
}
