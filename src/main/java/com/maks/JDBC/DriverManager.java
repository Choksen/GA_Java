package com.maks.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DriverManager {
    public static Connection getConnection() throws SQLException {
        final ResourceBundle bundle = ResourceBundle.getBundle("connection");
        final String url = bundle.getString("url");
        final String login = bundle.getString("login");
        final String password = bundle.getString("password");
        Connection conn = null;
        try {
            conn = java.sql.DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
