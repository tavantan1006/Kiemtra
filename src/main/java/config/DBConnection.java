package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456a";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //gọi driver của mysql
            connection = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
