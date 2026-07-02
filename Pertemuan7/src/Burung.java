// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 30 April 2026

public class Burung extends Anabul {

    public Burung(String nama) {
        super(nama);
    }

    @Override
    public void Gerak() {
        System.out.println(nama + " [Burung] bergerak dengan terbang.");
    }

    @Override
    public void Bersuara() {
        System.out.println(nama + " [Burung] bersuara: Cuit!");
    }
}
