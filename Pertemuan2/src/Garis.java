// Nama File   : Garis.java
// Deskripsi   : Berisi atribut dan method dalam class Garis
// Pembuat     : Joshua Satria Kusuma - 24060124130113
// Tangga;     : 1 Maret 2026

public class Garis{
    // ATRIBUT 
    private Titik t1;
    private Titik t2;
    private static int counterGaris = 0;
    
    // METHOD
    // Konstruktor untuk membuat Garis
    Garis(){
        t1 = new Titik(0,0);
        t2 = new Titik(1,1);
        counterGaris++;
    }

    Garis(Titik t1, Titik t2){
        if (t1.getAbsis() == t2.getAbsis() && t1.getOrdinat() == t2.getOrdinat()) {
            throw new IllegalArgumentException("Dua titik tidak boleh sama");
        } 

        this.t1 = new Titik(t1.getAbsis(), t1.getOrdinat());
        this.t2 = new Titik(t2.getAbsis(), t2.getOrdinat());
        counterGaris++;
    }

    // mengembalikan nilai counter Garis 
    static int getCounterGaris(){
        return counterGaris;
    }

    // mengembalikan nilai t1
    Titik getT1(){
        return new Titik(t1.getAbsis(), t1.getOrdinat());
    }

    // mengembalikan nilai t2
    Titik getT2(){
        return new Titik(t2.getAbsis(), t2.getOrdinat());
    }

    // mengeset t1 garis dengan nilai baru x 
    void setT1(Titik x){
        if (x.getAbsis() == t2.getAbsis() && x.getOrdinat() == t2.getOrdinat()) {
            throw new IllegalArgumentException("Dua titik tidak boleh sama");
        }

        this.t1 = new Titik(x.getAbsis(),x.getOrdinat());
    }

    // mengeset t2 garis dengan nilai baru x
    void setT2(Titik x){
        if (x.getAbsis() == t1.getAbsis() && x.getOrdinat() == t1.getOrdinat()) {
            throw new IllegalArgumentException("Dua titik tidak boleh sama");
        }

        this.t2 = new Titik(x.getAbsis(),x.getOrdinat());
    }

    // mengembalikan panjang dari sebuah garis
    double getPanjang(){
        return t1.getJarak(t2);
    }

    // mengembalikan gradien(kemiringan) dari sebuah garis
    double getGradien(){
        double deltaX = (double)(t2.getAbsis() - t1.getAbsis());
        double deltaY = (double)(t2.getOrdinat() - t1.getOrdinat());
        if (deltaX == 0) {
            throw new ArithmeticException("Gradien tidak terdefinisi");
        }

        return deltaY / deltaX;
    }

    //mengembalikan titik tengah dari sebuah garis
    Titik getMidPoint(){
        Titik midPoint = new Titik((t1.getAbsis() + t2.getAbsis())/2 , (t1.getOrdinat() + t2.getOrdinat())/2);
        return midPoint;
    }

    // mengembalikan true jika kedua garis sejajar, dan false jika kedua garis tidak sejajar
    boolean isParallel(Garis g){
        double deltaX1 = this.t2.getAbsis() - this.t1.getAbsis();
        double deltaY1 = this.t2.getOrdinat() - this.t1.getOrdinat();

        double deltaX2 = g.t2.getAbsis() - g.t1.getAbsis();
        double deltaY2 = g.t2.getOrdinat() - g.t1.getOrdinat();

        return deltaY1 * deltaX2 == deltaY2 * deltaX1;
    }   
    
    // mengembalikan true jika kedua garis tegak lurus, dan false jika kedua garis tidak tegak lurus
    boolean isPerpendicular(Garis g){
        double deltaX1 = this.t2.getAbsis() - this.t1.getAbsis();
        double deltaY1 = this.t2.getOrdinat() - this.t1.getOrdinat();

        double deltaX2 = g.t2.getAbsis() - g.t1.getAbsis();
        double deltaY2 = g.t2.getOrdinat() - g.t1.getOrdinat();

        return (deltaY1 * deltaY2) + (deltaX2 * deltaX1) == 0;
    }   

    // mencetak titik awal dan titik akhir dari suatu garis
    String getGaris(){
        return "Titik awal = (" + t1.getAbsis() + "," + t1.getOrdinat() + ")\n" +
               "Titik akhir = (" + t2.getAbsis() + "," + t2.getOrdinat() +")";
    }

    // mencetak persamaan garis dalam bentuk string y = mx + c.
    String getEquation(){
        if (t1.getAbsis() == t2.getAbsis()) {
            return "x = " + t1.getAbsis();
        } else {
            double m = (t2.getOrdinat() - t1.getOrdinat()) / (t2.getAbsis() - t1.getAbsis());
            double c = t1.getOrdinat() - m * t1.getAbsis();
            return "y = " + m + "x + " + c;
        }
    }

} // end class Garis