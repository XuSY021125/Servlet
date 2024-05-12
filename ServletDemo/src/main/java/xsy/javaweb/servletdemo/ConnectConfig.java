package xsy.javaweb.servletdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "xsy021125";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}