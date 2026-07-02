// Nama File   : Mtitik.java
// Deskripsi   : Berisi objek Titik dan memanggil method yang telah dibuat di class titik
// Pembuat     : Joshua Satria Kusuma - 24060124130113
// Tangga;     : 28 Februari 2026

public class Mtitik {
    public static void main(String[] args) {
        Titik T1 = new Titik();
        Titik T2 = new Titik();
        T1.setAbsis(3);
        T1.setOrdinat(4);
        T2.setAbsis(3);
        T2.setOrdinat(4);
        T1.printTitik();
        T1.geser(3, 4);
        T1.printTitik();
        System.out.println("Kuadran = " + T1.getKuadran());
        System.out.println("Jarak pusat = " + T1.getJarakPusat());
        System.out.println("Jarak T1 dnegan T2 = " + T1.getJarak(T2));
        
        T1.refleksiX();
        T1.printTitik();
        T1.refleksiY();
        T1.printTitik();

        Titik T3 = T2.getRefleksiX();
        T3.printTitik();
        T3.getRefleksiY();
        T3.printTitik();
    }
}
