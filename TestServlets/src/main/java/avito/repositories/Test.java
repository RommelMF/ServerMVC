package avito.repositories;

import java.sql.*;

/**
 * Created by Home on 18.01.2017.
 */
public class Test {


    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
             connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test_servlets", "postgres", "postgres");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select nameu from users WHERE id = 1;");
            String name = null;
            while(rs.next()) {
                name = rs.getString("nameu");
            }
            System.out.println(name);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }



    }
}
