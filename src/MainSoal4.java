package src;
// Nama    : Joshua Satria Kusuma 

// NIM     : 24060124130113
// Tanggal : 7 Mei 2026

public class MainSoal4 {
    public static void main(String[] args) {

        System.out.println("====== SOAL 4a: Kelas Generik Data<T> - Integer ======");

        Data<Integer> dataInt = new Data<>();
        dataInt.setIsi(1, 100);
        dataInt.setIsi(2, 200);
        dataInt.setIsi(3, 300);

        System.out.println("  getIsi(1) = " + dataInt.getIsi(1));
        System.out.println("  getIsi(2) = " + dataInt.getIsi(2));
        System.out.println("  getIsi(3) = " + dataInt.getIsi(3));
        System.out.println("  getSize() = " + dataInt.getSize());

        // Uji posisi kosong
        System.out.println("  getIsi(5) = " + dataInt.getIsi(5) + " (kosong/null)");

        // Uji batas luar jangkauan
        System.out.print("  setIsi(0,  999): ");
        dataInt.setIsi(0, 999);
        System.out.print("  setIsi(101, 999): ");
        dataInt.setIsi(101, 999);

        // ============================================================
        System.out.println("\n====== SOAL 4a: Kelas Generik Data<T> - String ======");
        // ============================================================

        Data<String> dataStr = new Data<>();
        dataStr.setIsi(1, "Informatika");
        dataStr.setIsi(2, "Sistem Informasi");
        dataStr.setIsi(5, "Teknik Elektro");

        System.out.println("  getIsi(1) = " + dataStr.getIsi(1));
        System.out.println("  getIsi(2) = " + dataStr.getIsi(2));
        System.out.println("  getIsi(5) = " + dataStr.getIsi(5));
        System.out.println("  getSize() = " + dataStr.getSize());

        System.out.println("\n====== SOAL 4b: setIsi untuk keluarga Anabul ======");

        Data<Anabul> dataAnabul = new Data<>();

        // Isi berbagai keturunan Anabul
        dataAnabul.setIsi(1, new Kucing("Tom", 4.2));
        dataAnabul.setIsi(2, new Anggora("Fluffy", 3.8));
        dataAnabul.setIsi(3, new Kembangtelon("Belang", 5.1));
        dataAnabul.setIsi(4, new Anjing("Rex"));
        dataAnabul.setIsi(5, new Burung("Tweety"));

        System.out.println("  Berhasil setIsi posisi 1-5 dengan berbagai Anabul.");

        // Update salah satu posisi
        dataAnabul.setIsi(1, new Kembangtelon("Kopi", 4.5));
        System.out.println("  Update posisi 1 menjadi Kembangtelon(Kopi).");

        System.out.println("\n====== SOAL 4c: getIsi untuk keluarga Anabul ======");

        System.out.println("  Isi larik Data<Anabul>:");
        for (int i = 1; i <= 5; i++) {
            Anabul a = dataAnabul.getIsi(i);
            System.out.print("    [" + i + "] " + a + " -> ");
            a.Bersuara();
        }

        // Ambil elemen spesifik dan gunakan
        System.out.println("\n  getIsi(2) dan panggil Gerak():");
        Anabul anabul2 = dataAnabul.getIsi(2);
        System.out.print("    ");
        anabul2.Gerak();

        System.out.println("\n====== SOAL 4d: getSize untuk keluarga Anabul ======");

        System.out.println("  Jumlah elemen efektif: " + dataAnabul.getSize());

        // Tambah lebih banyak lagi
        dataAnabul.setIsi(10, new Anjing("Buddy"));
        dataAnabul.setIsi(20, new Burung("Pita"));
        System.out.println("  Setelah tambah 2 elemen lagi...");
        System.out.println("  Jumlah elemen efektif: " + dataAnabul.getSize());

        System.out.println("\n====== SOAL 4b-d: Data<Kucing> - hanya keluarga Kucing ======");

        Data<Kucing> dataKucing = new Data<>();
        dataKucing.setIsi(1, new Kucing("Garfield", 6.0));
        dataKucing.setIsi(2, new Anggora("Luna", 4.0));
        dataKucing.setIsi(3, new Kembangtelon("Susu", 5.3));

        System.out.println("  Isi larik Data<Kucing>:");
        for (int i = 1; i <= 3; i++) {
            Kucing k = dataKucing.getIsi(i);
            System.out.println("    [" + i + "] " + k + " - bobot: " + k.getBobot() + " kg");
        }
        System.out.println("  getSize() = " + dataKucing.getSize());
    }
}
