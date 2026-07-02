package src;
// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 7 Mei 2026

public abstract class Anabul {
    protected String nama;

    public Anabul(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public abstract void Gerak();

    public abstract void Bersuara();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + nama + ")";
    }
}
