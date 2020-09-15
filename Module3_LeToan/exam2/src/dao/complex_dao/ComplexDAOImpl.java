package dao.complex_dao;

import bo.common_bo.Regex;
import dao.DBConnection;
import model.Complex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComplexDAOImpl implements ComplexDAO {
    private static final String SELECT_ALL_COMPLEX = "SELECT * FROM complex;";
    private static final String SELECT_COMPLEX_BY_ID = "SELECT * FROM complex WHERE complex_id = ?;";
    private static final String DELETE_COMPLEX_BY_ID = "DELETE FROM complex WHERE complex_id = ?;";
    private static final String CREATE_NEW_COMPLEX = "INSERT INTO complex (complex_id, complex_status, complex_area, complex_floor, " +
            "complex_type, complex_cost, complex_start_date, complex_end_date) VALUES" +
            "(?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SEARCH_COMPLEX = "SELECT * FROM complex WHERE complex_id LIKE ?" +
            "OR product_name LIKE ?;";
    private static final String CHECK_COMPLEX_ID_EXISTS = "SELECT 1 FROM complex WHERE complex_id = ?;";

    @Override
    public List<Complex> findAllComplex() {
        List<Complex> complexList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_COMPLEX);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("complex_id");
                    String status = resultSet.getString("complex_status");
                    double area = resultSet.getDouble("complex_area");
                    int floor = resultSet.getInt("complex_floor");
                    String type = resultSet.getString("complex_type");
                    double cost = resultSet.getDouble("complex_cost");
                    String startDate = Regex.changeFormatDateDisplay(resultSet.getString("complex_start_date"));
                    String endDate = Regex.changeFormatDateDisplay(resultSet.getString("complex_end_date"));
                    complexList.add(new Complex(id, status, area, floor, type, cost, startDate, endDate));
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
        return complexList;
    }

    @Override
    public Complex findComplexById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Complex complex = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_COMPLEX_BY_ID);
                preparedStatement.setString(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String status = resultSet.getString("complex_status");
                    double area = resultSet.getDouble("complex_area");
                    int floor = resultSet.getInt("complex_floor");
                    String type = resultSet.getString("complex_type");
                    double cost = resultSet.getDouble("complex_cost");
                    String startDate = Regex.changeFormatDateDisplay(resultSet.getString("complex_start_date"));
                    String endDate = Regex.changeFormatDateDisplay(resultSet.getString("complex_end_date"));
                    complex = new Complex(id, status, area, floor, type, cost, startDate, endDate);
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
        return complex;

    }

//    @Override
//    public boolean editProductInfo(Complex product) {
//        boolean rowEdit = false;
//        Connection connection = DBConnection.getConnection();
//        PreparedStatement preparedStatement = null;
//        if (connection != null) {
//            try {
//                preparedStatement = connection.prepareStatement(EDIT_PRODUCT_INFO);
//                preparedStatement.setInt(7, product.getProductId());
//                preparedStatement.setString(1, product.getProductName());
//                preparedStatement.setDouble(2, product.getProductPrice());
//                preparedStatement.setInt(3, product.getProductAmount());
//                preparedStatement.setString(4, product.getProductColor());
//                preparedStatement.setString(5, product.getProductDescription());
//                preparedStatement.setInt(6, product.getProductCategoryId());
//                rowEdit = preparedStatement.executeUpdate() > 0;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (preparedStatement != null) {
//                        preparedStatement.close();
//                    }
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                DBConnection.close();
//            }
//        }
//        return rowEdit;
//
//    }

    @Override
    public boolean deleteComplex(String id) {
        boolean rowDelete = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_COMPLEX_BY_ID);
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
    public void create(Complex complex) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(CREATE_NEW_COMPLEX);
                preparedStatement.setString(1, complex.getComplexCode());
                preparedStatement.setString(2, complex.getComplexStatus());
                preparedStatement.setDouble(3, complex.getComplexArea());
                preparedStatement.setInt(4, complex.getComplexFloor());
                preparedStatement.setString(5, complex.getComplexType());
                preparedStatement.setDouble(6, complex.getComplexCost());
                preparedStatement.setString(7, Regex.changeFormatDateSQL(complex.getComplexStartDate()));
                preparedStatement.setString(8, Regex.changeFormatDateSQL(complex.getComplexEndDate()));
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
    public List<Complex> search(String search) {
        List<Complex> complexList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SEARCH_COMPLEX);
                preparedStatement.setString(1, "%" + search + "%");
                preparedStatement.setString(2, "%" + search + "%");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("complex_id");
                    String status = resultSet.getString("complex_status");
                    double area = resultSet.getDouble("complex_area");
                    int floor = resultSet.getInt("complex_floor");
                    String type = resultSet.getString("complex_type");
                    double cost = resultSet.getDouble("complex_cost");
                    String startDate = Regex.changeFormatDateDisplay(resultSet.getString("complex_start_date"));
                    String endDate = Regex.changeFormatDateDisplay(resultSet.getString("complex_end_date"));
                    complexList.add(new Complex(id, status, area, floor, type, cost, startDate, endDate));
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
        return complexList;

    }

    @Override
    public boolean checkComplexIdExists(String id) {
        boolean checkExists = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(CHECK_COMPLEX_ID_EXISTS);
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
