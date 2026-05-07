package src;
// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 7 Mei 2026

public class MainSoal1dan2 {
    public static void main(String[] args) {

        System.out.println("====== SOAL 1a & 1b: Hirarki Kucing ======");

        Kucing        kucingBiasa = new Kucing("Tom",       4.2);
        Anggora       anggora     = new Anggora("Fluffy",   3.8);
        Kembangtelon  kembang     = new Kembangtelon("Belang", 5.1);

        System.out.println("Objek-objek kucing:");
        System.out.println("  " + kucingBiasa);
        System.out.println("  " + anggora);
        System.out.println("  " + kembang);

        System.out.println("\nSimulasi bunyi dan gerak:");
        kucingBiasa.Gerak();    kucingBiasa.Bersuara();
        anggora.Gerak();        anggora.Bersuara();
        kembang.Gerak();        kembang.Bersuara();

        System.out.println("\n====== SOAL 2: Kelas Generik Datum<T> ======");

        // Datum berisi Integer
        Datum<Integer> datumInt = new Datum<>(42);
        System.out.println("\n-- Datum<Integer> --");
        System.out.println("  getIsi()  : " + datumInt.getIsi());
        datumInt.setIsi(99);
        System.out.println("  setIsi(99) lalu getIsi(): " + datumInt.getIsi());

        // Datum berisi String
        Datum<String> datumStr = new Datum<>("Halo Dunia");
        System.out.println("\n-- Datum<String> --");
        System.out.println("  getIsi()  : " + datumStr.getIsi());
        datumStr.setIsi("Praktikum Generik");
        System.out.println("  setIsi(...) lalu getIsi(): " + datumStr.getIsi());

        // Datum berisi Anabul (Kucing)
        Datum<Anabul> datumAnabul = new Datum<>(kucingBiasa);
        System.out.println("\n-- Datum<Anabul> berisi Kucing --");
        System.out.println("  getIsi()  : " + datumAnabul.getIsi());
        datumAnabul.getIsi().Bersuara();

        // Ganti isi dengan Anggora (polimorfisme + generik)
        datumAnabul.setIsi(anggora);
        System.out.println("\n  setIsi(anggora) lalu getIsi(): " + datumAnabul.getIsi());
        datumAnabul.getIsi().Gerak();
        datumAnabul.getIsi().Bersuara();

        // Ganti isi dengan Anjing
        Anjing anjing = new Anjing("Rex");
        datumAnabul.setIsi(anjing);
        System.out.println("\n  setIsi(anjing) lalu getIsi(): " + datumAnabul.getIsi());
        datumAnabul.getIsi().Bersuara();

        // Datum berisi Kucing (bounded - hanya kucing dan turunannya)
        Datum<Kucing> datumKucing = new Datum<>(anggora);
        System.out.println("\n-- Datum<Kucing> berisi Anggora --");
        System.out.println("  getIsi()  : " + datumKucing.getIsi());
        System.out.println("  Bobot     : " + datumKucing.getIsi().getBobot() + " kg");

        datumKucing.setIsi(kembang);
        System.out.println("\n  setIsi(kembang) lalu getIsi(): " + datumKucing.getIsi());
        System.out.println("  Bobot     : " + datumKucing.getIsi().getBobot() + " kg");
    }
}
