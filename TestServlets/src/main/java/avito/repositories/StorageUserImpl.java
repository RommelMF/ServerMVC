package avito.repositories;

import avito.models.User;

import java.util.List;

/**
 * Created by Home on 16.01.2017.
 */
public class StorageUserImpl implements StorageUsers {
    private static final StorageUserImpl INSTANCE = new StorageUserImpl();
    // тут можно менять реализацию хранилища users
//    public static final StorageUsers storageUsers = new UserRepository();
    public static final StorageUsers storageUsers = new JdbcUsersStorage();

    public static StorageUserImpl getInstance() {
        return INSTANCE;
    }

    public void userAdd(String name, String email, String password, String login) {
        this.storageUsers.userAdd(name, email, password, login);
    }

    public List<User> getAll() {
        return this.storageUsers.getAll();
    }

    public void close() {
        this.storageUsers.close();
    }
}
