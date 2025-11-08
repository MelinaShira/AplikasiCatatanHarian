package database;

import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:catatan.db";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
