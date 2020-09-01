package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/user_manager?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Toan0902872813";

    private static final String CREATE_NEW_USER = "INSERT INTO users" + "  (name, email, address) VALUES " + " (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String SELECT_ALL_USER = "SELECT * FROM users";
    private static final String DELETE_USER = "DELETE FROM users WHERE id = ?;";
    private static final String UPDATE_USER = "UPDATE users SET name = ?, email= ?, address = ? WHERE id = ?;";
    private static final String TEST = "{call test(?,'Toan', @x, @y);}";
//    private static final String SP_INSERT_USER = "{CALL insert_user (?,?,?)}" ;
//    private static final String SP_FIND_BY_ID = "{CALL get_user_by_id (?)}" ;


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public void createUser(User user) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            preparedStatement = connection.prepareStatement(CREATE_NEW_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    userList.add(new User(id, name, email, address));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDelete = false;
        Connection connection = getConnection();
        PreparedStatement preparedStatement;
        if (connection != null) {
            preparedStatement = getConnection().prepareStatement(DELETE_USER);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdate = false;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setInt(4, user.getId());
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getAddress());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public User selectUserById(int id) {
        User user = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    user = new User(id, name, email, address);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public void addUserTransaction(User user, int[] permissions) {
        Connection connection = getConnection();
        PreparedStatement addUserStatement = null;
        PreparedStatement insertPermissionStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
                addUserStatement = connection.prepareStatement(CREATE_NEW_USER, Statement.RETURN_GENERATED_KEYS);
                addUserStatement.setString(1, user.getName());
                addUserStatement.setString(2, user.getEmail());
                addUserStatement.setString(3, user.getAddress());
                int rowAffected = addUserStatement.executeUpdate();

                resultSet = addUserStatement.getGeneratedKeys();
                int userId = 0;
                if (resultSet.next()) {
                    userId = resultSet.getInt(1);
                }

                if (rowAffected == 1) {
                    String ADD_PERMISSION = "INSERT INTO user_permission (user_id, permission_id) VALUES (?,?);";
                    insertPermissionStatement = connection.prepareStatement(ADD_PERMISSION);
                    for (int permission : permissions) {
                        insertPermissionStatement.setInt(1, userId);
                        insertPermissionStatement.setInt(2, permission);
                        insertPermissionStatement.executeUpdate();
                    }
                    connection.commit();
                } else {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                try {
                        if (connection != null) {
                            connection.rollback();
                        }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(ex.getMessage());
            } finally {
                try {
                    if (resultSet != null) resultSet.close();

                    if (addUserStatement != null) addUserStatement.close();

                    if (insertPermissionStatement != null) insertPermissionStatement.close();

                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
