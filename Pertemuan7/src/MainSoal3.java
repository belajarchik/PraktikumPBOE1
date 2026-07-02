// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 30 April 2026

public class MainSoal3 {
    public static void main(String[] args) {

        Anabul[] anabuls = {
            new Kucing("Kitty"),
            new Kucing("Luna"),
            new Anjing("Rex"),
            new Anjing("Doggo"),
            new Burung("Tweety")
        };

        System.out.println("====== SIMULASI BUNYI DAN GERAKAN ANABUL ======\n");
        for (Anabul a : anabuls) {
            System.out.println(a.getNama() + "=");
            a.Gerak();   
            a.Bersuara(); 
            System.out.println();
        }
    }
}
