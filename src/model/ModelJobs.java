/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import entity.Jobs;
import util.DBUtil;

/**
 *
 * @author firman_hutasoit
 */
public class ModelJobs {
    
    public static int addJob(Jobs job) {
    String query = """
        INSERT INTO jobs 
        (nama_perusahaan, role_pekerjaan, title, status_pekerjaan, 
         lokasi_pekerjaan, pengalaman, gaji, deskripsi_pekerjaan, 
         kualifikasi, finished, logo_perusahaan) 
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """;

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setString(1, job.getNamaPerusahaan());
        stmt.setString(2, job.getRolePekerjaan());
        stmt.setString(3, job.getTitle());
        stmt.setString(4, job.getStatusPekerjaan());
        stmt.setString(5, job.getLokasiPekerjaan());
        stmt.setString(6, job.getPengalaman());
        stmt.setString(7, job.getGaji());
        stmt.setString(8, job.getDeskripsiPekerjaan());
        stmt.setString(9, job.getKualifikasi());
        stmt.setBoolean(10, job.getFinished());
        stmt.setBytes(11, job.getLogoPerusahaan());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1); // Kembalikan ID yang baru saja dibuat
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1;
    }
    
    
    public static boolean updateJob(Jobs job) {
    String query = """
        UPDATE jobs 
        SET nama_perusahaan = ?, role_pekerjaan = ?, title = ?, status_pekerjaan = ?, 
            lokasi_pekerjaan = ?, pengalaman = ?, gaji = ?, deskripsi_pekerjaan = ?, 
            kualifikasi = ?, finished = ?, logo_perusahaan = ? 
        WHERE id = ?
    """;

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, job.getNamaPerusahaan());
        stmt.setString(2, job.getRolePekerjaan());
        stmt.setString(3, job.getTitle());
        stmt.setString(4, job.getStatusPekerjaan());
        stmt.setString(5, job.getLokasiPekerjaan());
        stmt.setString(6, job.getPengalaman());
        stmt.setString(7, job.getGaji());
        stmt.setString(8, job.getDeskripsiPekerjaan());
        stmt.setString(9, job.getKualifikasi());
        stmt.setBoolean(10, job.getFinished());
        stmt.setBytes(11, job.getLogoPerusahaan());
        stmt.setInt(12, job.getId());

        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0; // Kembalikan true jika ada baris yang diubah
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
    }
    
    
    public static boolean deleteJob(int jobId) {
    String query = "DELETE FROM jobs WHERE id = ?";

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, jobId);

        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0; // Kembalikan true jika ada baris yang dihapus
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
    }


    public static ArrayList<Jobs> getAllJobs(String keyword) {
    ArrayList<Jobs> jobs = new ArrayList<>();
    String query = "SELECT * FROM jobs";
    if (keyword != null && !keyword.isEmpty()) {
        query += " WHERE title LIKE ? OR nama_perusahaan LIKE ?";
    }
    query += " ORDER BY created_at DESC";

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        if (keyword != null && !keyword.isEmpty()) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
        }

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Jobs job = new Jobs(
                rs.getInt("id"),
                rs.getString("nama_perusahaan"),
                rs.getString("role_pekerjaan"),
                rs.getString("title"),
                rs.getString("status_pekerjaan"),
                rs.getString("lokasi_pekerjaan"),
                rs.getString("pengalaman"),
                rs.getString("gaji"),
                rs.getString("deskripsi_pekerjaan"),
                rs.getString("kualifikasi"),
                rs.getBoolean("finished"),
                rs.getBytes("logo_perusahaan"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")
            );
            jobs.add(job);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return jobs;
    }
    
    public static ArrayList<Jobs> searchJobsByKeyword(String keyword) {
    ArrayList<Jobs> jobs = new ArrayList<>();
    String query = "SELECT * FROM jobs WHERE (role_pekerjaan LIKE ? OR nama_perusahaan LIKE ?) ORDER BY created_at DESC";

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
         
        // Set parameter dengan wildcard (%keyword%)
        String searchKeyword = "%" + keyword + "%";
        stmt.setString(1, searchKeyword);
        stmt.setString(2, searchKeyword);
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            jobs.add(new Jobs(
                rs.getInt("id"),
                rs.getString("nama_perusahaan"),
                rs.getString("role_pekerjaan"),
                rs.getString("title"),
                rs.getString("status_pekerjaan"),
                rs.getString("lokasi_pekerjaan"),
                rs.getString("pengalaman"),
                rs.getString("gaji"),
                rs.getString("deskripsi_pekerjaan"),
                rs.getString("kualifikasi"),
                rs.getBoolean("finished"),
                rs.getBytes("logo_perusahaan"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return jobs;
    }
    
    public static ArrayList<Jobs> getJobsByRole(String rolePekerjaan) {
    ArrayList<Jobs> jobs = new ArrayList<>();
    String query = "SELECT * FROM jobs WHERE role_pekerjaan LIKE ? ORDER BY created_at DESC";

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, "%" + rolePekerjaan + "%"); // Mencari berdasarkan role pekerjaan

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            jobs.add(new Jobs(
                rs.getInt("id"),
                rs.getString("nama_perusahaan"),
                rs.getString("role_pekerjaan"),
                rs.getString("title"),
                rs.getString("status_pekerjaan"),
                rs.getString("lokasi_pekerjaan"),
                rs.getString("pengalaman"),
                rs.getString("gaji"),
                rs.getString("deskripsi_pekerjaan"),
                rs.getString("kualifikasi"),
                rs.getBoolean("finished"),
                rs.getBytes("logo_perusahaan"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return jobs;
    }


    
    
    
}
