package avito.repositories;

import avito.models.User;

import java.util.List;

/**
 * Created by Home on 16.01.2017.
 */
public interface StorageUsers {

    public void userAdd(String name, String email, String password, String login);

    public List<User> getAll();

    public void close();
}
