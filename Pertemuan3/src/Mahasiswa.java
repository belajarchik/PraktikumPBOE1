import java.util.ArrayList;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String prodi;
    private ArrayList<MataKuliah> listMatkul;
    private Dosen dosenWali;
    private Kendaraan kendaraan;

        public Mahasiswa(String nim, String nama, String prodi){
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    public String getNim(){
        return this.nim;
    }

    public String getNama(){
        return this.nama;
    }

    public String getProdi(){
        return this.prodi;
    }

    public Dosen getDosenWali(){
        return this.dosenWali;
    }

    public Kendaraan getKendaraan(){
        return this.kendaraan;
    }

    public void setNim(String nim){
        this.nim = nim;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setProdi(String prodi){
        this.prodi = prodi;
    }

    public void setDosenWali(Dosen dosenWali){
        this.dosenWali = dosenWali;
    }

    public void setKendaraan(Kendaraan kendaraan){
        this.kendaraan = kendaraan;
    }

    public void addMatkul(MataKuliah matkul){
        this.listMatkul.add(matkul);
    }

    public int getJumlahSKS(){
        int count = 0;

        for(int i = 0; i < listMatkul.size(); i++){
            count = count + listMatkul.get(i).getSks();
        }
        return count;
    }

    public int getJumlahMatkul(){
        int count = 0;
        for(int i = 0; i < listMatkul.size(); i++){
            count++;
        }

        return count;
    } 

    public void printMhs(){
        System.out.println(this.nim);
        System.out.println(this.nama);
        System.out.println(this.prodi);
    }

    public void printDetailMhs(){
        System.out.println("NIM : " + this.nim);
        System.out.println("Nama : " + this.nama);
        System.out.println("Prodi : " + this.prodi);
        System.out.println("Dosen Wali : " + this.dosenWali);
        for (int i = 0; i < listMatkul.size(); i++) {
            System.out.println(listMatkul.get(i).getNama());
        }
    }
} 