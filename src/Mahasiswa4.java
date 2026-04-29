// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 30 April 2026

public class Mahasiswa4 extends Civitasakademika {
    private String NIM;
    private Dosen  Dosenwali;

    public Mahasiswa4(String nama, String nim) {
        super(nama);
        this.NIM       = nim;
        this.Dosenwali = null;
    }

    public String getNIM() { 
        return NIM; 
    }

    public Dosen  getDosenwali() { 
        return Dosenwali; 
    }

    @Override
    public String getNomor() {
        return NIM;  
    }

    public void setWali(Dosen d) {
        this.Dosenwali = d;
    }

    public void tampilDataMahasiswa() {
        System.out.println("  NIM         : " + NIM);
        System.out.println("  Nama        : " + Nama);
        System.out.println("  Dosenwali   : " + Dosenwali.getNama());
    }
}
