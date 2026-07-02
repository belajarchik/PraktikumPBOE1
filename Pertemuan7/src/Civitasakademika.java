// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 30 April 2026
public abstract class Civitasakademika {
    protected String Nama;

    public Civitasakademika(String nama) {
        this.Nama = nama;
    }

    public String getNama() { 
        return Nama; 
    }

    public abstract String getNomor();
}
