package avito.repositories;

import avito.Settings;
import avito.models.Product;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Home on 18.01.2017.
 */
public class JdbcProductsStorage implements StorageProducts {

    private final Connection connection;

    private static int idP = 0;

    public JdbcProductsStorage() {
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

    public List<Product> getAll() {
        return null;
    }

    public void addProduct(String title, int quantity, double price, String specification) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("insert into products (id, title, quantity, price, specification) VALUES (?, ?, ?, ?, ?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public boolean removeProduct(int id) {
        return false;
    }

    public Product getById(int id) {
        return null;
    }

    public boolean editProduct(int id, String title, int quantity, double price, String specification) {
        return false;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
