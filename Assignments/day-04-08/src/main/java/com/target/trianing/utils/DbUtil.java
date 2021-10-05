package com.target.trianing.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class DbUtil {

    //don't let anyone instantiate this class
    private DbUtil(){}

    public static Connection createConnection() throws SQLException {

        ResourceBundle rb = ResourceBundle.getBundle("jdbc-info");

        String url = rb.getString("jdbc.connection.url");  //jdbc:mysql://localhost/target_training_db
        String username = rb.getString("jdbc.connection.username");
        String password = rb.getString("jdbc.connection.password");
        return DriverManager.getConnection(url, username, password);
    }
}
