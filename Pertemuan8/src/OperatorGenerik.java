package src;
// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 7 Mei 2026

public class OperatorGenerik {

    public static <T> T[] Tukar(T[] pasangan) {
        T temp = pasangan[0];
        pasangan[0] = pasangan[1];
        pasangan[1] = temp;
        return pasangan;
    }

    public static <T extends Kucing> double Bobot2(T kucing1, T kucing2) {
        return kucing1.getBobot() + kucing2.getBobot();
    }
}
