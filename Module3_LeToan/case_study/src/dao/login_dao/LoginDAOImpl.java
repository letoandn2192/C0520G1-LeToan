package dao.login_dao;

import dao.DBConnection;
import model.User;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {
    private static final String SELECT_USER = "SELECT * FROM user WHERE username = ? AND password = ?;";

    @Override
    public User findUser(String userName, String pass) {
        User user = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_USER);
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, pass);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String userId = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    user = new User(userName, password);
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
        return user;
    }
}
