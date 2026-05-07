package src;
// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 7 Mei 2026

public class MainSoal3 {
    public static void main(String[] args) {

        System.out.println("====== SOAL 3a & 3b: Prosedur Generik Tukar ======");

        // --- Tukar sesama Integer ---
        System.out.println("\n-- Tukar<Integer> --");
        Integer[] pairInt = {3, 6};
        System.out.println("  Sebelum: a=" + pairInt[0] + ", b=" + pairInt[1]);
        OperatorGenerik.Tukar(pairInt);
        System.out.println("  Sesudah: a=" + pairInt[0] + ", b=" + pairInt[1]);

        // --- Tukar sesama String ---
        System.out.println("\n-- Tukar<String> --");
        String[] pairStr = {"Kucing", "Anjing"};
        System.out.println("  Sebelum: a=" + pairStr[0] + ", b=" + pairStr[1]);
        OperatorGenerik.Tukar(pairStr);
        System.out.println("  Sesudah: a=" + pairStr[0] + ", b=" + pairStr[1]);

        // --- Tukar sesama keluarga Anabul ---
        System.out.println("\n-- Tukar<Anabul> (Anjing vs Kucing) --");
        Anjing  rex    = new Anjing("Rex");
        Kucing  tom    = new Kucing("Tom", 4.2);
        Anabul[] pairAnabul = {rex, tom};
        System.out.println("  Sebelum: a=" + pairAnabul[0] + ", b=" + pairAnabul[1]);
        OperatorGenerik.Tukar(pairAnabul);
        System.out.println("  Sesudah: a=" + pairAnabul[0] + ", b=" + pairAnabul[1]);

        // --- Tukar sesama Kucing (Anggora vs Kembangtelon) ---
        System.out.println("\n-- Tukar<Kucing> (Anggora vs Kembangtelon) --");
        Anggora      fluffy = new Anggora("Fluffy", 3.8);
        Kembangtelon belang = new Kembangtelon("Belang", 5.1);
        Kucing[] pairKucing = {fluffy, belang};
        System.out.println("  Sebelum: a=" + pairKucing[0] + ", b=" + pairKucing[1]);
        OperatorGenerik.Tukar(pairKucing);
        System.out.println("  Sesudah: a=" + pairKucing[0] + ", b=" + pairKucing[1]);

        System.out.println("\n====== SOAL 3c: Fungsi Generik Bobot2 ======");

        // Bobot2 dengan dua Kucing biasa
        Kucing kucingA = new Kucing("Kitty",  3.5);
        Kucing kucingB = new Kucing("Garfield", 6.0);
        double totalKucing = OperatorGenerik.Bobot2(kucingA, kucingB);
        System.out.println("\n-- Bobot2(Kucing, Kucing) --");
        System.out.println("  " + kucingA + " + " + kucingB);
        System.out.println("  Jumlah bobot: " + totalKucing + " kg");

        // Bobot2 dengan dua Anggora
        Anggora a1 = new Anggora("Luna",  4.0);
        Anggora a2 = new Anggora("Mochi", 3.2);
        double totalAnggora = OperatorGenerik.Bobot2(a1, a2);
        System.out.println("\n-- Bobot2(Anggora, Anggora) --");
        System.out.println("  " + a1 + " + " + a2);
        System.out.println("  Jumlah bobot: " + totalAnggora + " kg");

        // Bobot2 dengan dua Kembangtelon
        Kembangtelon k1 = new Kembangtelon("Kopi",  4.8);
        Kembangtelon k2 = new Kembangtelon("Susu",  5.3);
        double totalKembang = OperatorGenerik.Bobot2(k1, k2);
        System.out.println("\n-- Bobot2(Kembangtelon, Kembangtelon) --");
        System.out.println("  " + k1 + " + " + k2);
        System.out.println("  Jumlah bobot: " + totalKembang + " kg");

        // Bobot2 dengan campuran Anggora dan Kembangtelon
        double totalCampur = OperatorGenerik.Bobot2(fluffy, belang);
        System.out.println("\n-- Bobot2(Anggora, Kembangtelon) --");
        System.out.println("  " + fluffy + " + " + belang);
        System.out.println("  Jumlah bobot: " + totalCampur + " kg");
    }
}
