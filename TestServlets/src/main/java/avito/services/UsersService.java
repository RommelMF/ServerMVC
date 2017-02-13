package avito.services;

import avito.repositories.StorageUserImpl;
import avito.repositories.StorageUsers;
import avito.repositories.UserRepository;
import avito.models.User;

/**
 * Created by Home on 12.01.2017.
 */
public class UsersService {

    private static final UsersService INSTANCE = new UsersService();
//    private UserRepository userRepository = UserRepository.getINSTANCE();
    private StorageUserImpl storageUser = StorageUserImpl.getInstance();

    public static UsersService getINSTANCE() {
        return INSTANCE;
    }

    public  boolean securityUser(String login, String password) {
        boolean isThere = false;
        for (User userList : this.storageUser.getAll()) {
            if (userList.getLogin().equals(login) & userList.getPassword().equals(password)) {
                isThere = true;
            }
        }
        return isThere;
    }
}

