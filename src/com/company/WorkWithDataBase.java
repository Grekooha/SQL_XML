package com.company;
import java.sql.*;

public class WorkWithDataBase {

    static void addATableIfNone() {
        Connection connection = DataBaseHandler.getDbConnection();
        try (Statement statement = connection.createStatement()) {
            System.out.println("Executing statement...");
            String SQL = "CREATE TABLE IF NOT EXISTS test (" +
                    "id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY," +
                    "field INTEGER not NULL) ";

            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("\n*****************\n");
        System.out.println("Is done.");
    }

    static void clearDataFromTheTableTest() {
        Connection connection = DataBaseHandler.getDbConnection();
        String SQL = "DELETE FROM test";

        try (Statement statement = connection.createStatement()) {
            System.out.println("Executing statement...");
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("\n*****************\n");
        System.out.println("Is done.");
    }

    public static void fillingInTheTable(int n) {
        Connection connection = DataBaseHandler.getDbConnection();
        String SQL = "INSERT INTO test (field) VALUES (?);";

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {

            System.out.println("Executing statement...");

            int batchCounter = 0;
            for (int i = 1; i <= n; i++) {

                statement.setInt(1, i);
                statement.addBatch();
                if (batchCounter == 5000 || i == n) {
                    statement.executeBatch();
                    batchCounter = 0;
                }
                batchCounter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("\n*\n");
        System.out.println("Is done.");

    }
}