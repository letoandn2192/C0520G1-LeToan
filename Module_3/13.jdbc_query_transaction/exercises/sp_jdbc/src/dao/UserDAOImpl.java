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
    private static final String SP_SELECT_ALL_USER = "{CALL select_all_user()}";
    private static final String SP_DELETE_USER = "CALL delete_user(?)";
    private static final String SP_UPDATE_USER = "CALL update_user(?,?,?,?)";
    private static final String SP_INSERT_USER = "CALL insert_user (?,?,?)" ;
    private static final String SP_FIND_BY_ID = "CALL get_user_by_id (?)" ;


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

    @Override
    public void createUser(User user) {
        System.out.println(CREATE_NEW_USER);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_USER))
        {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
             printSQLException(e);
        }
    }

    @Override
    public List<User> selectAllUser() {
        Connection connection = getConnection();
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        if (connection != null) {
            try {
                callableStatement = connection.prepareCall(SP_SELECT_ALL_USER);
                resultSet = callableStatement.executeQuery();
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
        CallableStatement callableStatement = null;
        if (connection != null) {
            callableStatement = connection.prepareCall(SP_DELETE_USER);
            callableStatement.setInt(1, id);
            rowDelete = callableStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdate = false;
        Connection connection = getConnection();
        CallableStatement callableStatement = null;
        if (connection != null) {
            callableStatement = connection.prepareCall(SP_UPDATE_USER);
            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getAddress());
            rowUpdate = callableStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public User selectUserById(int id) {
        User user = null;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID))
        {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
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
        return user;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        Connection connection = getConnection();
        CallableStatement callableStatement = null;
        if (connection != null) {
            callableStatement = connection.prepareCall(SP_INSERT_USER);
            callableStatement.setString(1,user.getName());
            callableStatement.setString(2,user.getEmail());
            callableStatement.setString(3,user.getAddress());
            callableStatement.executeUpdate();
        }
    }

    @Override
    public User getUserById(int id) {
        Connection connection = getConnection();
        CallableStatement callableStatement = null;
        User user = null;
        if (connection != null) {
            try {
                callableStatement = connection.prepareCall(SP_FIND_BY_ID);
                callableStatement.setInt(1, id);
                ResultSet resultSet = callableStatement.executeQuery();
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
}
