package avito.repositories;

import avito.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 13.01.2017.
 */
public class UserRepository implements StorageUsers{

    private static final UserRepository INSTANCE = new UserRepository();
    private static int ids = 0;

    private List<User> users = new ArrayList<User>();

    public static UserRepository getINSTANCE() {
        return INSTANCE;
    }

    public void userAdd(String name, String email, String password, String login) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setLogin(login);
        user.setId(++ids);

        users.add(user.getId() - 1, user);
    }

    public List<User> getAll() {
        return users;
    }

    public void close() {

    }
}
