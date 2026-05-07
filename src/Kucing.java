package src;
// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 7 Mei 2026

public class Kucing extends Anabul {
    // (1a) Atribut bobot dalam kilogram
    protected double bobot;

    public Kucing(String nama, double bobot) {
        super(nama);
        this.bobot = bobot;
    }

    public double getBobot() { return bobot; }
    public void   setBobot(double bobot) { this.bobot = bobot; }

    @Override
    public void Gerak() {
        System.out.println(nama + " [Kucing] bergerak dengan melata.");
    }

    @Override
    public void Bersuara() {
        System.out.println(nama + " [Kucing] bersuara: Meong!");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + nama + ", bobot=" + bobot + "kg)";
    }
}
