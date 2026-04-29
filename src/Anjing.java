// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 30 April 2026
public class Anjing extends Anabul {

    public Anjing(String nama) {
        super(nama);
    }

    @Override
    public void Gerak() {
        System.out.println(nama + " [Anjing] bergerak dengan melata.");
    }

    @Override
    public void Bersuara() {
        System.out.println(nama + " [Anjing] bersuara: Guk-guk!");
    }
}
