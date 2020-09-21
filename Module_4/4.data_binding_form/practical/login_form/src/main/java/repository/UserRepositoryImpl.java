package repository;

import model.Login;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User("john", "123456789", "John", "john@gmail.com", 20));
        users.add(new User("henry", "123456789", "Henry", "henry@gmail.com", 25));
        users.add(new User("jame", "123456789", "Jame", "jame@gmail.com", 34));
        users.add(new User("david", "123456789", "David", "david@gmail.com", 15));
    }

    @Override
    public User checkLogin(Login login) {
        for (User user: users) {
            if(user.getAccount().equals(login.getAccount())
                    && user.getPassword().equals(login.getPassword())){
                return user;
            }
        }
        return null;
    }
}
