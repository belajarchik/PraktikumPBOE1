// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 30 April 2026
public class MainSoal4 {
    public static void main(String[] args) {

        Dosen dosen1 = new Dosen("Dr. Budi Santoso",   "198001012005011001");
        Dosen dosen2 = new Dosen("Prof. Sari Wulandari","197505152000122002");

        Mahasiswa4 mhs1 = new Mahasiswa4("Andi Wijaya",     "23001");
        Mahasiswa4 mhs2 = new Mahasiswa4("Bela Permata",    "23002");
        Mahasiswa4 mhs3 = new Mahasiswa4("Candra Putra",    "23003");
        Mahasiswa4 mhs4 = new Mahasiswa4("Dita Rahayu",     "23004");
        Mahasiswa4 mhs5 = new Mahasiswa4("Eko Firmansyah",  "23005");

        Seminar seminar = new Seminar();

        seminar.registrasi(dosen1);
        seminar.registrasi(dosen2);
        seminar.registrasi(mhs1);
        seminar.registrasi(mhs2);
        seminar.registrasi(mhs3);
        seminar.registrasi(mhs4);
        seminar.registrasi(mhs5);

        System.out.println("  Total peserta   : " + seminar.countPeserta());

        System.out.println("  Jumlah mahasiswa: " + seminar.countMahasiswa());

        seminar.tampilPeserta();

        mhs1.setWali(dosen1);
        mhs2.setWali(dosen1);
        mhs3.setWali(dosen2);
        mhs4.setWali(dosen2);
        mhs5.setWali(dosen1);
        System.out.println("  Dosen wali berhasil di-set untuk semua mahasiswa.");

        Mahasiswa4[] semuaMhs = {mhs1, mhs2, mhs3, mhs4, mhs5};
        for (Mahasiswa4 mahas : semuaMhs) {
            System.out.println("  ---");
            mahas.tampilDataMahasiswa();
        }
    }
}
