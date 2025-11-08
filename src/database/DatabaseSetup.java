package database;

import java.sql.*;

public class DatabaseSetup {
    public static void main(String[] args) {
        String sql = "CREATE TABLE IF NOT EXISTS catatan ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "tanggal TEXT NOT NULL,"
                + "judul TEXT NOT NULL,"
                + "isi TEXT NOT NULL"
                + ");";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabel 'catatan' berhasil dibuat!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
