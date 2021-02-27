package com.company;

import java.sql.*;

class DataBaseHandler extends Configs {

    static Connection connection;

    public static Connection getDbConnection() {
        if (connection == null) {
            try {
                System.out.println("Registering JDBC driver...");
                Class.forName("org.postgresql.Driver");
                Configs cn = new Configs();
                System.out.println("Creating database connection...");
                connection = DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPass());
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }
}
