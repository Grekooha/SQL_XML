package com.grekooha.testproj;

import java.sql.*;

class DataBaseHandler {

    static Connection connection;

    public static Connection getDbConnection() {

        if (connection == null) {
//            try {
//            } catch (ClassNotFoundException e) {
//                System.out.println("Can't find class. Message: " + e.getMessage());
//            }

            try {
                Class.forName("org.postgresql.Driver");
                System.out.println("Registering JDBC driver...");
                Configs cn = new Configs();
                System.out.println("Creating database connection...");
                connection = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPass());
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Can't establish connection. Message: " + e.getMessage());
            }
        }
        return connection;
    }
}
