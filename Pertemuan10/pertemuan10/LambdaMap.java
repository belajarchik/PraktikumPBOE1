package pertemuan10;

import java.util.LinkedHashMap;
import java.util.Map;


public class LambdaMap {
    public static void main(String[] args) {

        Map<String, String> mahasiswaMap = new LinkedHashMap<>();

        // Isi data mahasiswa
        mahasiswaMap.put("24060121130055", "Adi Prasetyo");
        mahasiswaMap.put("24060121140061", "Bambang Susilo");
        mahasiswaMap.put("24060121130072", "Cici Rahayu");
        mahasiswaMap.put("24060121140088", "Didi Kurniawan");
        mahasiswaMap.put("24060121130099", "Eka Putri");

        System.out.println("=== Data Mahasiswa (NIM -> Nama) ===");

        // Lambda dengan dua parameter: nim dan nama
        // forEach pada Map secara otomatis meneruskan key dan value
        mahasiswaMap.forEach((nim, nama) -> {
            System.out.println("NIM  : " + nim);
            System.out.println("Nama : " + nama);
            System.out.println("----------------------------");
        });

        // Alternatif: tampilkan dalam satu baris per entri
        System.out.println("\n=== Format Ringkas ===");
        mahasiswaMap.forEach((nim, nama) -> System.out.println(nim + " | " + nama));
    }
}