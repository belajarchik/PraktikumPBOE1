// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 30 April 2026

public class Mahasiswa2 {

    // atribut
    private int NIM;
    private String Nama;
    private String Programstudi;

    // method
    // Konstruktor tanpaparameter
    public Mahasiswa2() {
        this.NIM = -999;
        this.Nama = "n/a";
        this.Programstudi = "n/a";
    }

    // Konstruktor tiga parameter
    public Mahasiswa2(int nim, String nama, String programstudi) {
        this.NIM = nim;
        this.Nama = nama;
        this.Programstudi = programstudi;
    }

    // Konstruktor kloning dari objek Mahasiswa lain
    public Mahasiswa2(Mahasiswa2 sumber) {
        this.NIM = sumber.NIM;
        this.Nama = sumber.Nama;
        this.Programstudi = sumber.Programstudi;
    }

    // Getter
    public int getNIM() {
        return NIM;
    }

    public String getNama() {
        return Nama;
    }

    public String getProgramstudi() {
        return Programstudi;
    }

    // Setter
    public void setNIM(int nim) {
        this.NIM = nim;
    }

    public void setNama(String nama) {
        this.Nama = nama;
    }

    // Setter tanpa parameter
    public void setProgramStudi() {
        this.Programstudi = "Kosong";
    }

    // Setter 1 parameter string
    public void setProgramStudi(String prodi) {
        this.Programstudi = prodi;
    }

    // Setter 1 parameter objek mahasiswa lain
    public void setProgramStudi(Mahasiswa2 mhs) {
        this.Programstudi = mhs.Programstudi;
    }

    public void printInfo() {
        System.out.println("  NIM         : " + NIM);
        System.out.println("  Nama        : " + Nama);
        System.out.println("  Programstudi: " + Programstudi);
    }
}
