package bo.login_bo;

import dao.login_dao.LoginDAO;
import dao.login_dao.LoginDAOImpl;
import model.User;

public class LoginBOImpl implements LoginBO {
    private LoginDAO loginDAO = new LoginDAOImpl();
    @Override
    public User findUser(String userId, String pass) {
        return loginDAO.findUser(userId, pass);
    }
}
