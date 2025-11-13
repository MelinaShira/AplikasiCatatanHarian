package model;

public class Catatan {
    private int id;
    private String tanggal;
    private String judul;
    private String isi;

    // 🟢 Constructor kosong (wajib untuk DAO)
    public Catatan() {}

    // 🟡 Constructor lengkap (opsional, untuk kemudahan instansiasi)
    public Catatan(int id, String tanggal, String judul, String isi) {
        this.id = id;
        this.tanggal = tanggal;
        this.judul = judul;
        this.isi = isi;
    }

    // 🧩 Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
