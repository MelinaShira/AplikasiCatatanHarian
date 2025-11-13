package model;

import database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatatanDAO {

    public boolean insert(Catatan c) {
        String sql = "INSERT INTO catatan (tanggal, judul, isi) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getTanggal());
            ps.setString(2, c.getJudul());
            ps.setString(3, c.getIsi());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Catatan c) {
        String sql = "UPDATE catatan SET tanggal=?, judul=?, isi=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getTanggal());
            ps.setString(2, c.getJudul());
            ps.setString(3, c.getIsi());
            ps.setInt(4, c.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM catatan WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Catatan> getAll() {
        List<Catatan> list = new ArrayList<>();
        String sql = "SELECT * FROM catatan ORDER BY tanggal DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Catatan c = new Catatan();
                c.setId(rs.getInt("id"));
                c.setTanggal(rs.getString("tanggal"));
                c.setJudul(rs.getString("judul"));
                c.setIsi(rs.getString("isi"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Catatan> search(String keyword) {
        List<Catatan> list = new ArrayList<>();
        String sql = "SELECT * FROM catatan WHERE judul LIKE ? OR isi LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Catatan c = new Catatan();
                c.setId(rs.getInt("id"));
                c.setTanggal(rs.getString("tanggal"));
                c.setJudul(rs.getString("judul"));
                c.setIsi(rs.getString("isi"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
