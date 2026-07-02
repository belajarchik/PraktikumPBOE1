// Nama File   : Mgaris.java
// Deskripsi   : Berisi objek Garis dan memanggil method yang telah dibuat di class garis
// Pembuat     : Joshua Satria Kusuma - 24060124130113
// Tangga;     : 1 Maret 2026

public class Mgaris {
    public static void main(String[] args) {
        Titik T1 = new Titik(3, 7);
        Titik T2 = new Titik(5, 1);
        Garis G1 = new Garis();
        G1.setT1(T1);
        G1.setT2(T2);
        Garis G2 = new Garis(new Titik(5, 7), new Titik(7, 1));
        System.out.println(G1.getGaris());
        System.out.println(G2.getGaris());
        System.out.println("Panjang G1 = " + G1.getPanjang());
        System.out.println("Gradien G1 = " + G1.getGradien());
        Titik midG1 = G1.getMidPoint();
        System.out.println("Titik tengah G = (" + midG1.getAbsis() + "," + midG1.getOrdinat() + ")");
        System.out.println("Apakah G1 dan G2 sejajar = " + G1.isParallel(G2));
        System.out.println("Apakah G1 dan G2 tegak lurus = " + G1.isPerpendicular(G2));
        System.out.println(G1.getEquation());

    }
}
