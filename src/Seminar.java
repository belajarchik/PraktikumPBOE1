// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 30 April 2026

public class Seminar {

    private Civitasakademika[] pesertas;
    private int banyakpeserta;

    public Seminar() {
        pesertas      = new Civitasakademika[100];
        banyakpeserta = 0;
    }

    public int countPeserta() {
        return banyakpeserta;
    }

    public void registrasi(Civitasakademika c) {
        if (banyakpeserta < 100) {
            pesertas[banyakpeserta] = c;
            banyakpeserta++;
            System.out.println(c.getNama() + " berhasil diregistrasi.");
        } else {
            System.out.println("gagal diregistrasi, kapasitas seminar penuh!");
        }
    }

    public void tampilPeserta() {
        System.out.println("  No  | Nomor (NIM/NIP) | Nama");
        System.out.println("  ----|-----------------|------------------");
        for (int i = 0; i < banyakpeserta; i++) {
            System.out.printf("  %-3d | %-15s | %s%n",
                (i + 1),
                pesertas[i].getNomor(),
                pesertas[i].getNama());
        }
    }

    public int countMahasiswa() {
        int count = 0;
        for (int i = 0; i < banyakpeserta; i++) {
            if (pesertas[i] instanceof Mahasiswa4) {
                count++;
            }
        }
        return count;
    }
}
