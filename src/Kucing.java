// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 30 April 2026
public class Kucing extends Anabul {

    public Kucing(String nama) {
        super(nama);
    }

    @Override
    public void Gerak() {
        System.out.println(nama + " [Kucing] bergerak dengan melata.");
    }

    @Override
    public void Bersuara() {
        System.out.println(nama + " [Kucing] bersuara: Meong!");
    }
}
