// Nama File   : Titik.java
// Deskripsi   : Berisi atribut dan method dalam class Titik
// Pembuat     : Joshua Satria Kusuma - 24060124130113
// Tangga;     : 19 Februari 2026

public class Titik{
    // ATTRIBUT
    double absis;
    double ordinat;

    // METHOD
    // Konstruktor untuk membuat titik
    Titik(){
        absis = 0;
        ordinat = 0;
    }

    // mengembalikan nilai absis
    double getAbsis(){
        return absis;
    }

    // mengembalikan nilai ordinat
    double getOrdinat(){
        return ordinat;
    }

    // mengeset absis titik dengan nilai baru x 
    void setAbsis(double x){
        absis = x;
    }

    // mengeset ordinat titik dengan nilai baru y
    void setOrdinat(double y){
        ordinat = y;
    }

    // menggeser absis titik sejauh x dan ordinat titik sejauh y
    void geser(double x, double y){
        absis = absis + x;
        ordinat = ordinat + y;
    }

    // mencetak koordinat titik
    void printTitik(){
        System.out.println("Titik (" + absis + "," + ordinat + ")");
    }
} // end class Titik
