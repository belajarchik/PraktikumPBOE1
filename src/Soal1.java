// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 30 April 2026

public class Soal1 {
    public static void main(String[] args) {
        int angka = 65;
        char karakter = (char) angka;
        double real = (double) angka;

        System.out.println("Nilai integer : " + angka);
        System.out.println("Sebagai char  : " + karakter);
        System.out.println("Sebagai double: " + real);

        double nilaiReal = (double) angka;
        int kembaliInt = (int) nilaiReal;

        System.out.println("Nilai real    : " + nilaiReal);
        System.out.println("Kembali ke int: " + kembaliInt);

        String X = "1234";
        String Y = "5678";
        String S = X + Y;
        Integer Z = Integer.parseInt(X) + Integer.parseInt(Y);

        System.out.println("X = " + X + ", Y = " + Y);
        System.out.println("S (konkatenasi) = " + S);
        System.out.println("Z (penjumlahan) = " + Z);

        String P = "12.34";
        String Q = "56.78";
        String R = P + Q;
        Double D = Double.parseDouble(P) + Double.parseDouble(Q);

        System.out.println("P = " + P + ", Q = " + Q);
        System.out.println("R (konkatenasi) = " + R);
        System.out.println("D (penjumlahan) = " + D);

        Integer A = Integer.parseInt(S);
        System.out.println("A = " + A);

        String T = A.toString();
        System.out.println("T = " + T);

    }
}
