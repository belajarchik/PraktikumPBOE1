// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 30 April 2026

public class MainSoal2 {
    public static void main(String[] args) {

        Mahasiswa2 mhs1 = new Mahasiswa2();
        mhs1.printInfo();

        Mahasiswa2 mhs2 = new Mahasiswa2(23001, "Budi Santoso", "Informatika");
        mhs2.printInfo();

        Mahasiswa2 mhs3 = new Mahasiswa2(mhs2);
        mhs3.printInfo();
        
        mhs1.setProgramStudi();
        System.out.println("Hasil setter tanpa parameter");
        mhs1.printInfo();

        mhs1.setNIM(23002);
        mhs1.setNama("Sari Dewi");
        mhs1.setProgramStudi("Sistem Informasi");
        System.out.println("\nHasil setter 1 parameter string");
        mhs1.printInfo();

        Mahasiswa2 mhs4 = new Mahasiswa2(23003, "Andi Wijaya", "n/a");
        mhs4.setProgramStudi(mhs2);
        System.out.println("\nHasil setter dengan parameter objek mahasiswa lain");
        mhs4.printInfo();
    }
}
