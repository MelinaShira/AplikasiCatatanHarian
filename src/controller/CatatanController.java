package controller;

import java.util.List;
import model.Catatan;
import model.CatatanDAO;

public class CatatanController {

    private CatatanDAO dao = new CatatanDAO();

    public boolean insertCatatan(Catatan c) {
        return dao.insert(c);
    }

    public boolean updateCatatan(Catatan c) {
        return dao.update(c);
    }

    public boolean deleteCatatan(int id) {
        return dao.delete(id);
    }

    public List<Catatan> getAllCatatan() {
        return dao.getAll();
    }

    public List<Catatan> searchCatatan(String keyword) {
        return dao.search(keyword);
    }
}
