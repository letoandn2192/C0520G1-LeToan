package dao.product_dao;

import dao.DBConnection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDao {
    private static final String SELECT_ALL_PRODUCT = "SELECT * FROM product;";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM product WHERE product_id = ?;";
    private static final String EDIT_PRODUCT_INFO = "UPDATE product SET product_name = ?, product_price = ?, product_amount = ?, " +
            "product_color = ?, product_description = ?, product_category_id = ? WHERE product_id = ?;";
    private static final String DELETE_PRODUCT_BY_ID = "DELETE FROM product WHERE product_id = ?;";
    private static final String CREATE_NEW_PRODUCT = "INSERT INTO product (product_name, product_price, product_amount, product_color, " +
            "product_description, product_category_id) VALUES" +
            "(?, ?, ?, ?, ?, ?);";
    private static final String SEARCH_PRODUCT = "SELECT * FROM product WHERE product_id LIKE ?" +
            "OR product_name LIKE ?;";

    @Override
    public List<Product> findAllProduct() {
        List<Product> productList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("product_id");
                    String name = resultSet.getString("product_name");
                    double price = resultSet.getDouble("product_price");
                    int amount = resultSet.getInt("product_amount");
                    String color = resultSet.getString("product_color");
                    String description = resultSet.getString("product_description");
                    int categoryId = resultSet.getInt("product_category_id");
                    productList.add(new Product(id, name, price, amount, color, description, categoryId));
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
        return productList;
    }

    @Override
    public Product findProductById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("product_name");
                    double price = resultSet.getDouble("product_price");
                    int amount = resultSet.getInt("product_amount");
                    String color = resultSet.getString("product_color");
                    String description = resultSet.getString("product_description");
                    int categoryId = resultSet.getInt("product_category_id");
                    product = new Product(id, name, price, amount, color, description, categoryId);
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
        return product;

    }

    @Override
    public boolean editProductInfo(Product product) {
        boolean rowEdit = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(EDIT_PRODUCT_INFO);
                preparedStatement.setInt(7, product.getProductId());
                preparedStatement.setString(1, product.getProductName());
                preparedStatement.setDouble(2, product.getProductPrice());
                preparedStatement.setInt(3, product.getProductAmount());
                preparedStatement.setString(4, product.getProductColor());
                preparedStatement.setString(5, product.getProductDescription());
                preparedStatement.setInt(6, product.getProductCategoryId());
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
    public boolean deleteProduct(int id) {
        boolean rowDelete = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
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
    public void create(Product product) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(CREATE_NEW_PRODUCT);
                preparedStatement.setString(1, product.getProductName());
                preparedStatement.setDouble(2, product.getProductPrice());
                preparedStatement.setInt(3, product.getProductAmount());
                preparedStatement.setString(4, product.getProductColor());
                preparedStatement.setString(5, product.getProductDescription());
                preparedStatement.setInt(6, product.getProductCategoryId());
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
    public List<Product> search(String search) {
        List<Product> productList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SEARCH_PRODUCT);
                preparedStatement.setString(1, "%" + search + "%");
                preparedStatement.setString(2, "%" + search + "%");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("product_id");
                    String name = resultSet.getString("product_name");
                    double price = resultSet.getDouble("product_price");
                    int amount = resultSet.getInt("product_amount");
                    String color = resultSet.getString("product_color");
                    String description = resultSet.getString("product_description");
                    int categoryId = resultSet.getInt("product_category_id");
                    productList.add(new Product(id, name, price, amount, color, description, categoryId));
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
        return productList;

    }
}
