// Nama File   : Titik.java
// Deskripsi   : Berisi atribut dan method dalam class Titik
// Pembuat     : Joshua Satria Kusuma - 24060124130113
// Tangga;     : 28 Februari 2026

public class Titik{
    // ATTRIBUT
    double absis;
    double ordinat;
    static int counterTitik = 0;

    // METHOD
    // Konstruktor untuk membuat titik
    Titik(){
        absis = 0;
        ordinat = 0;
        counterTitik++;
    }

    Titik(double absis, double ordinat){
        this.absis = absis;
        this.ordinat = ordinat;
        counterTitik++;
    }

    // mengembalikan nilai counter titik 
    static int getCounterTitik(){
        return counterTitik;
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

    // mengembalikan letak kuadran titik
    int getKuadran(){
        if (absis > 0 && ordinat > 0) {
            return 1;
        } else if (absis < 0 && ordinat > 0) {
            return 2;
        } else if (absis < 0 && ordinat < 0) {
            return 3;
        } else if (absis > 0 && ordinat < 0){
            return 4;
        } else{
            return 0;
        }   
    }

    // mengembalikan jarak titik dari titik pusat(0,0)
    double getJarakPusat(){
        return Math.sqrt(Math.pow(absis, 2) + Math.pow(ordinat, 2));
    }

    // mengembalikan jarak titik dari suatu titik lain 
    double getJarak(Titik T){
        return Math.sqrt(Math.pow(absis - T.absis, 2) + Math.pow(ordinat - T.ordinat,2));
    }

    // merefleksi titik terhadap sumbu X
    void refleksiX(){
        ordinat = -ordinat;
    }

    // merefleksi titik terhadap sumbu Y
    void refleksiY(){
        absis = -absis;
    }

    // mengembalikan titik hasil refleksi terhadap sumbu X
    Titik getRefleksiX(){
        return new Titik(absis, -ordinat);
    }

    // mengembalikan titik hasil refleksi terhadap sumbu Y
    Titik getRefleksiY(){
        return new Titik(-absis, ordinat);
    }

} // end class Titik
