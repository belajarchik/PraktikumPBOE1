package src;
// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 7 Mei 2026

public class Data<T> {

    // Larik statis 100 elemen bertipe generik
    @SuppressWarnings("unchecked")
    private T[] ruang = (T[]) new Object[100];

    // Banyaknya elemen efektif
    private int banyak;

    // Konstruktor
    public Data() {
        this.banyak = 0;
    }

    public void setIsi(int posisi, T objek) {
        if (posisi < 1 || posisi > 100) {
            System.out.println("  [ERROR] Posisi " + posisi + " di luar jangkauan (1-100).");
            return;
        }
        if (ruang[posisi - 1] == null) {
            banyak++;
        }
        ruang[posisi - 1] = objek;
    }

    public T getIsi(int posisi) {
        if (posisi < 1 || posisi > 100) {
            System.out.println("  [ERROR] Posisi " + posisi + " di luar jangkauan (1-100).");
            return null;
        }
        return ruang[posisi - 1];
    }

    public int getSize() {
        return banyak;
    }
}
