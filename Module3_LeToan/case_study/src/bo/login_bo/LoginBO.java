package bo.login_bo;

import model.User;

public interface LoginBO {
    User findUser(String userName, String password);
}
