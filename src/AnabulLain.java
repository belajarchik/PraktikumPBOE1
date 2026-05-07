package src;
// Nama    : Joshua Satria Kusuma 
// NIM     : 24060124130113
// Tanggal : 7 Mei 2026

class Anjing extends Anabul {
    public Anjing(String nama) { super(nama); }

    @Override
    public void Gerak()    { System.out.println(nama + " [Anjing] bergerak dengan melata."); }
    @Override
    public void Bersuara() { System.out.println(nama + " [Anjing] bersuara: Guk-guk!"); }
}

class Burung extends Anabul {
    public Burung(String nama) { super(nama); }

    @Override
    public void Gerak()    { System.out.println(nama + " [Burung] bergerak dengan terbang."); }
    @Override
    public void Bersuara() { System.out.println(nama + " [Burung] bersuara: Cuit!"); }
}
