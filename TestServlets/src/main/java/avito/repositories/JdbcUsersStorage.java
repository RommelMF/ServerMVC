package avito.repositories;

import avito.Settings;
import avito.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 16.01.2017.
 */
public class JdbcUsersStorage implements StorageUsers {

    private final Connection connection;

    private static int id = 2;

    public JdbcUsersStorage() {
        final Settings settings = Settings.getINSTANCE();
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }
    public void userAdd(String name, String email, String password, String login) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("insert into users (id, nameu, emailu, loginu, passwordu) VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1,++id);
            statement.setString(2,name);
            statement.setString(3,login);
            statement.setString(4,password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAll() {
        List<User> users = new ArrayList<User>();
        try  {
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");

            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("nameu"));
                user.setEmail(rs.getString("emailu"));
                user.setLogin(rs.getString("loginu"));
                user.setPassword(rs.getString("passwordu"));
                user.setId(rs.getInt("id"));
                users.add(user);
            }
            } catch (SQLException e) {
                e.printStackTrace();
        }
        return users;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
