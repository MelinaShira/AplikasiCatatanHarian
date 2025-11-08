package model;

import database.DatabaseConnection;
import java.sql.*;
import java.util.*;

public class CatatanDAO {

    public List<Catatan> getAllNotes() throws SQLException {
        List<Catatan> list = new ArrayList<>();
        String sql = "SELECT * FROM catatan";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Catatan(
                        rs.getInt("id"),
                        rs.getString("tanggal"),
                        rs.getString("judul"),
                        rs.getString("isi")));
            }
        }
        return list;
    }

    public void addNote(Catatan c) throws SQLException {
        String sql = "INSERT INTO catatan (tanggal, judul, isi) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getTanggal());
            ps.setString(2, c.getJudul());
            ps.setString(3, c.getIsi());
            ps.executeUpdate();
        }
    }

    public void updateNote(Catatan c) throws SQLException {
        String sql = "UPDATE catatan SET tanggal=?, judul=?, isi=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getTanggal());
            ps.setString(2, c.getJudul());
            ps.setString(3, c.getIsi());
            ps.setInt(4, c.getId());
            ps.executeUpdate();
        }
    }

    public void deleteNote(int id) throws SQLException {
        String sql = "DELETE FROM catatan WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Catatan> searchNotes(String keyword) throws SQLException {
        List<Catatan> list = new ArrayList<>();
        String sql = "SELECT * FROM catatan WHERE judul LIKE ? OR isi LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Catatan(
                        rs.getInt("id"),
                        rs.getString("tanggal"),
                        rs.getString("judul"),
                        rs.getString("isi")));
            }
        }
        return list;
    }
}
