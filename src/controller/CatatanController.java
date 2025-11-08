package controller;

import java.sql.SQLException;
import java.util.List;
import model.Catatan;
import model.CatatanDAO;

public class CatatanController {
    private CatatanDAO dao;

    public CatatanController() {
        dao = new CatatanDAO();
    }

    public List<Catatan> getAllNotes() throws SQLException {
        return dao.getAllNotes();
    }

    public void addNote(String tanggal, String judul, String isi) throws SQLException {
        dao.addNote(new Catatan(0, tanggal, judul, isi));
    }

    public void updateNote(int id, String tanggal, String judul, String isi) throws SQLException {
        dao.updateNote(new Catatan(id, tanggal, judul, isi));
    }

    public void deleteNote(int id) throws SQLException {
        dao.deleteNote(id);
    }

    public List<Catatan> searchNotes(String keyword) throws SQLException {
        return dao.searchNotes(keyword);
    }
}
