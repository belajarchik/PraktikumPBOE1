// Joshua Satria Kusuma
// 24060124130113
//　E1
package jdbc.model;

public class Mahasiswa {

    // Atribut sesuai tabel mahasiswa (id INT, nama VARCHAR)
    private int id;
    private String nama;

    // Constructor default
    public Mahasiswa() {
        this.id = 0;
        this.nama = "";
    }

    // Constructor dengan parameter
    public Mahasiswa(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" + "id=" + id + ", nama=" + nama + '}';
    }
}
