// Joshua Satria Kusuma
// 24060124130113
//　E1
package jdbc.service;

import jdbc.model.Mahasiswa;
import jdbc.utilities.MysqlUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlMahasiswaService {

    Connection koneksi = null;

    // Constructor: ambil koneksi dari utility
    public MysqlMahasiswaService() {
        koneksi = MysqlUtility.getConnection();
    }

    // -------------------------------------------------------------------------
    // makeMhsObject
    // Membuat objek Mahasiswa dari ResultSet (digunakan secara internal)
    // -------------------------------------------------------------------------
    public Mahasiswa makeMhsObject(ResultSet rs) {
        Mahasiswa mhs = new Mahasiswa();
        try {
            mhs.setId(rs.getInt("id"));
            mhs.setNama(rs.getString("nama"));
        } catch (SQLException e) {
            System.out.println("makeMhsObject error: " + e.getMessage());
        }
        return mhs;
    }

    // -------------------------------------------------------------------------
    // CREATE — Menambahkan data mahasiswa baru ke tabel
    // -------------------------------------------------------------------------
    public void add(Mahasiswa mhs) {
        String sql = "INSERT INTO mahasiswa (nama) VALUES (?)";
        try {
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setString(1, mhs.getNama());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Berhasil insert");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("add error: " + e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // UPDATE — Mengubah data mahasiswa berdasarkan id
    // -------------------------------------------------------------------------
    public void update(Mahasiswa mhs) {
        String sql = "UPDATE mahasiswa SET nama = ? WHERE id = ?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setString(1, mhs.getNama());
            ps.setInt(2, mhs.getId());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Berhasil update");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("update error: " + e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // DELETE — Menghapus data mahasiswa berdasarkan id
    // -------------------------------------------------------------------------
    public void delete(int id) {
        String sql = "DELETE FROM mahasiswa WHERE id = ?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Berhasil delete");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("delete error: " + e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // READ — Mengambil satu mahasiswa berdasarkan id
    // -------------------------------------------------------------------------
    public Mahasiswa getById(int id) {
        Mahasiswa mhs = null;
        String sql = "SELECT * FROM mahasiswa WHERE id = ?";
        try {
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mhs = makeMhsObject(rs);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("getById error: " + e.getMessage());
        }
        return mhs;
    }

    // -------------------------------------------------------------------------
    // READ ALL — Mengambil semua isi tabel mahasiswa
    // -------------------------------------------------------------------------
    public List<Mahasiswa> getAll() {
        List<Mahasiswa> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa ORDER BY id";
        try {
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(makeMhsObject(rs));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("getAll error: " + e.getMessage());
        }
        return list;
    }

    // -------------------------------------------------------------------------
    // INDEX RESET — Mereset auto increment tabel mahasiswa ke 1
    // Berguna untuk demo / pengujian ulang dari awal
    // -------------------------------------------------------------------------
    public void indexReset() {
        String sql = "ALTER TABLE mahasiswa AUTO_INCREMENT = 1";
        try {
            Statement st = koneksi.createStatement();
            st.executeUpdate(sql);
            st.close();
            System.out.println("Index di-reset ke 1");
        } catch (SQLException e) {
            System.out.println("indexReset error: " + e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // IS EMPTY — Memeriksa apakah tabel mahasiswa kosong
    // -------------------------------------------------------------------------
    public boolean isEmpty() {
        String sql = "SELECT COUNT(*) AS total FROM mahasiswa";
        try {
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                int total = rs.getInt("total");
                rs.close();
                st.close();
                return total == 0;
            }
        } catch (SQLException e) {
            System.out.println("isEmpty error: " + e.getMessage());
        }
        return true;
    }

    // -------------------------------------------------------------------------
    // CLOSE CONNECTION — Menutup koneksi ke basis data
    // -------------------------------------------------------------------------
    public void closeConnection() {
        MysqlUtility.closeConnection();
        koneksi = null;
    }
}
