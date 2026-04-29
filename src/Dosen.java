// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 30 April 2026

public class Dosen extends Civitasakademika {
    private String NIP;

    public Dosen(String nama, String nip) {
        super(nama);
        this.NIP = nip;
    }

    public String getNIP() {
        return NIP;
    }

    

    @Override
    public String getNomor() {
        return NIP; 
    }
}
