package src;
// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 7 Mei 2026

public class Datum<T> {

    // Atribut generik
    private T isi;

    // Konstruktor
    public Datum(T isi) {
        this.isi = isi;
    }

    // Fungsi getIsi - mengembalikan isi bertipe T
    public T getIsi() {
        return isi;
    }

    // Prosedur setIsi - mengubah isi dengan isibaru bertipe T
    public void setIsi(T isibaru) {
        this.isi = isibaru;
    }

    @Override
    public String toString() {
        return "Datum[" + isi + "]";
    }
}
