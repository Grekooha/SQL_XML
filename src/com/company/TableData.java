package com.company;

import java.sql.*;
import java.util.ArrayList;

public class TableData{

    static ArrayList<Integer> getField() {
        ArrayList<Integer> arrayField = new ArrayList<>();
        Connection connection = DataBaseHandler.getDbConnection();
        String sql = "SELECT * FROM test";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int field = resultSet.getInt("field");
                arrayField.add(field);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return arrayField;
    }
}
