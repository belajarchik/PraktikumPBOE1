// Nama File   : Mtitik.java
// Deskripsi   : Berisi objek Titik dan memanggil method yang telah dibuat di class titik
// Pembuat     : Joshua Satria Kusuma - 24060124130113
// Tangga;     : 19 Februari 2026

public class Mtitik {
    public static void main(String[] args) {
        Titik T1 = new Titik();
        T1.setAbsis(3);
        T1.setOrdinat(4);
        T1.printTitik();
        T1.geser(3, 4);
        T1.printTitik();
    }
}
