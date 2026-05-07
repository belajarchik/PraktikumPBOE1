package src;
// Nama    : Joshua Satria Kusuma 

// NIM     : 24060124130113
// Tanggal : 7 Mei 2026

public class Kembangtelon extends Kucing {

    public Kembangtelon(String nama, double bobot) {
        super(nama, bobot);
    }

    @Override
    public void Gerak() {
        System.out.println(nama + " [Kembangtelon] bergerak cepat sambil melata.");
    }

    @Override
    public void Bersuara() {
        System.out.println(nama + " [Kembangtelon] bersuara: Ngeoong!");
    }
}
