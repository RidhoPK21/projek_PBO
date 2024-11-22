/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.User;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author firman_hutasoit
 */
public class ModelUser {
    public static int addUser(User user) {
        String query = "INSERT INTO users (username, email, password, contact_number, profile_picture, role) " +
                       "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getContactNumber());
            stmt.setBytes(5, user.getProfilePicture());
            stmt.setString(6, user.getRole());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // Mengembalikan ID pengguna yang baru ditambahkan
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Gagal menambahkan pengguna
    }

    // Ambil semua pengguna
    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM users ORDER BY created_at DESC";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("contact_number"),
                    rs.getBytes("profile_picture"),
                    rs.getString("role"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Ambil pengguna berdasarkan ID
    public static User getUserById(int userId) {
        String query = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("contact_number"),
                    rs.getBytes("profile_picture"),
                    rs.getString("role"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Pengguna tidak ditemukan
    }

    // Update pengguna
    public static boolean updateUser(User user) {
        String query = "UPDATE users SET username = ?, email = ?, password = ?, contact_number = ?, " +
                       "profile_picture = ?, role = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getContactNumber());
            stmt.setBytes(5, user.getProfilePicture());
            stmt.setString(6, user.getRole());
            stmt.setInt(7, user.getId());

            return stmt.executeUpdate() > 0; // Mengembalikan true jika ada baris yang diupdate
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Gagal mengupdate
    }

    // Hapus pengguna berdasarkan ID
    public static boolean deleteUser(int userId) {
        String query = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            return stmt.executeUpdate() > 0; // Mengembalikan true jika ada baris yang dihapus
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Gagal menghapus pengguna
    }

    // Cari pengguna berdasarkan username atau email
    public static ArrayList<User> searchUsers(String keyword) {
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM users WHERE username LIKE ? OR email LIKE ? ORDER BY created_at DESC";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            String likeKeyword = "%" + keyword + "%";
            stmt.setString(1, likeKeyword);
            stmt.setString(2, likeKeyword);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                users.add(new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("contact_number"),
                    rs.getBytes("profile_picture"),
                    rs.getString("role"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
}
