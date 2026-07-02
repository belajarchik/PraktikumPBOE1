// Joshua Satria Kusuma
// 24060124130113
//　E1

package jdbc.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlUtility {

    private static Connection koneksi;

    /**
     * Mengembalikan koneksi ke basis data.
     * Jika koneksi belum ada, akan dibuat baru.
     *
     * CATATAN KONFIGURASI:
     * - Sesuaikan host, port, nama_db, user, dan password di bawah ini
     * - Jika menggunakan MySQL 8+, ganti driver class menjadi:
     * "com.mysql.cj.jdbc.Driver"
     * dan tambahkan parameter pada URL:
     * "?useSSL=false&serverTimezone=UTC"
     */
    public static Connection getConnection() {
        if (koneksi == null) {
            try {
                // Untuk MySQL 5.x (connector 5.1.x):
                Class.forName("com.mysql.jdbc.Driver");

                // Sesuaikan nama database, host, dan port
                String url = "jdbc:mysql://localhost:3306/jdbc_mhs";
                String user = "student"; // sesuaikan username
                String password = "rahasia"; // sesuaikan password

                koneksi = DriverManager.getConnection(url, user, password);

                if (koneksi != null) {
                    System.out.println("Koneksi berhasil");
                }

            } catch (ClassNotFoundException cne) {
                System.out.println("Gagal load driver : " + cne.getMessage());
            } catch (SQLException sqle) {
                System.out.println("Gagal Koneksi : " + sqle.getMessage());
            }
        }
        return koneksi;
    }

    /**
     * Menutup koneksi aktif ke basis data.
     * Dipanggil saat aplikasi ditutup.
     */
    public static void closeConnection() {
        if (koneksi != null) {
            try {
                koneksi.close();
                koneksi = null;
                System.out.println("Koneksi ditutup");
            } catch (SQLException sqle) {
                System.out.println("Gagal menutup koneksi : " + sqle.getMessage());
            }
        }
    }
}
