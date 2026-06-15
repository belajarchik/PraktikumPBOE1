// Joshua Satria Kusuma
// 24060124130113
//　E1
package jdbc.program;

import jdbc.model.Mahasiswa;
import jdbc.service.MysqlMahasiswaService;

import java.util.List;

/**
 * Program.java — Simulasi CRUD via console (Praktikum 3.1)
 *
 * Jalankan kelas ini untuk menguji operasi CRUD tanpa GUI.
 * Pastikan koneksi database sudah dikonfigurasi di MysqlUtility.java
 */
public class Program {

    static MysqlMahasiswaService service = new MysqlMahasiswaService();

    public static void main(String[] args) {

        List<Mahasiswa> listmhs;
        System.out.println("");

        // ----------------------------------------------------------------
        // INSERT
        // ----------------------------------------------------------------
        System.out.println("===insert");
        Mahasiswa mhsAdd = new Mahasiswa(5, "Haryo");
        service.add(mhsAdd);
        System.out.println("berhasil insert: " + mhsAdd);
        displayAll();

        // ----------------------------------------------------------------
        // UPDATE
        // ----------------------------------------------------------------
        System.out.println("===update");
        Mahasiswa mhsUpdate = service.getById(5);
        System.out.println("Akan diupdate data lama: " + mhsUpdate);
        mhsUpdate.setNama("Dinaya");
        System.out.println("dengan data baru: " + mhsUpdate);
        service.update(mhsUpdate);
        displayAll();

        // ----------------------------------------------------------------
        // DELETE
        // ----------------------------------------------------------------
        System.out.println("===delete");
        System.out.println("akan di delete: " + service.getById(5));
        service.delete(5);
        displayAll();

        // ----------------------------------------------------------------
        // Tutup koneksi setelah selesai
        // ----------------------------------------------------------------
        service.closeConnection();
    }

    /**
     * Menampilkan seluruh isi tabel mahasiswa ke console
     */
    static void displayAll() {
        System.out.println("===displayAll");
        List<Mahasiswa> list = service.getAll();
        for (Mahasiswa m : list) {
            System.out.println(m);
        }
        System.out.println("");
    }
}
