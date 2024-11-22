/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author firman_hutasoit
 */
import java.sql.Timestamp;

public class Jobs {
    private int id;                      // ID pekerjaan (primary key)
    private String namaPerusahaan;       // Nama perusahaan
    private String rolePekerjaan;        // Role pekerjaan
    private String title;                // Judul pekerjaan
    private String statusPekerjaan;      // Status pekerjaan
    private String lokasiPekerjaan;      // Lokasi pekerjaan
    private String pengalaman;           // Pengalaman yang dibutuhkan
    private String gaji;                 // Gaji
    private String deskripsiPekerjaan;   // Deskripsi pekerjaan
    private String kualifikasi;          // Kualifikasi pekerjaan
    private Boolean finished;            // Status pekerjaan selesai/tidak
    private byte[] logoPerusahaan;       // Gambar logo perusahaan (disimpan sebagai byte array)
    private Timestamp createdAt;         // Waktu pembuatan
    private Timestamp updatedAt;         // Waktu terakhir diperbarui

    // Constructor
    public Jobs() {
    }

    public Jobs(Integer id, 
                String namaPerusahaan, 
                String rolePekerjaan, 
                String title, 
                String statusPekerjaan, 
                String lokasiPekerjaan, 
                String pengalaman, 
                String gaji, 
                String deskripsiPekerjaan, 
                String kualifikasi, 
                Boolean finished, 
                byte[] logoPerusahaan, 
                Timestamp createdAt, 
                Timestamp updatedAt) {
        this.id = id;
        this.namaPerusahaan = namaPerusahaan;
        this.rolePekerjaan = rolePekerjaan;
        this.title = title;
        this.statusPekerjaan = statusPekerjaan;
        this.lokasiPekerjaan = lokasiPekerjaan;
        this.pengalaman = pengalaman;
        this.gaji = gaji;
        this.deskripsiPekerjaan = deskripsiPekerjaan;
        this.kualifikasi = kualifikasi;
        this.finished = finished;
        this.logoPerusahaan = logoPerusahaan;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    // Konstruktor tanpa ID (untuk data baru)
    public Jobs(String namaPerusahaan, String rolePekerjaan, String title, String statusPekerjaan,
                String lokasiPekerjaan, String pengalaman, String gaji, String deskripsiPekerjaan,
                String kualifikasi, Boolean finished, byte[] logoPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
        this.rolePekerjaan = rolePekerjaan;
        this.title = title;
        this.statusPekerjaan = statusPekerjaan;
        this.lokasiPekerjaan = lokasiPekerjaan;
        this.pengalaman = pengalaman;
        this.gaji = gaji;
        this.deskripsiPekerjaan = deskripsiPekerjaan;
        this.kualifikasi = kualifikasi;
        this.finished = finished;
        this.logoPerusahaan = logoPerusahaan;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getRolePekerjaan() {
        return rolePekerjaan;
    }

    public void setRolePekerjaan(String rolePekerjaan) {
        this.rolePekerjaan = rolePekerjaan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatusPekerjaan() {
        return statusPekerjaan;
    }

    public void setStatusPekerjaan(String statusPekerjaan) {
        this.statusPekerjaan = statusPekerjaan;
    }

    public String getLokasiPekerjaan() {
        return lokasiPekerjaan;
    }

    public void setLokasiPekerjaan(String lokasiPekerjaan) {
        this.lokasiPekerjaan = lokasiPekerjaan;
    }

    public String getPengalaman() {
        return pengalaman;
    }

    public void setPengalaman(String pengalaman) {
        this.pengalaman = pengalaman;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getDeskripsiPekerjaan() {
        return deskripsiPekerjaan;
    }

    public void setDeskripsiPekerjaan(String deskripsiPekerjaan) {
        this.deskripsiPekerjaan = deskripsiPekerjaan;
    }

    public String getKualifikasi() {
        return kualifikasi;
    }

    public void setKualifikasi(String kualifikasi) {
        this.kualifikasi = kualifikasi;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public byte[] getLogoPerusahaan() {
        return logoPerusahaan;
    }

    public void setLogoPerusahaan(byte[] logoPerusahaan) {
        this.logoPerusahaan = logoPerusahaan;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", namaPerusahaan='" + namaPerusahaan + '\'' +
                ", rolePekerjaan='" + rolePekerjaan + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}


