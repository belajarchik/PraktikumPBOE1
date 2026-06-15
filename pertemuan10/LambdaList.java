package pertemuan10;
import java.util.ArrayList;

public class LambdaList {
    public static void main(String[] args) {

        Arraylist<String> mahasiswalist = new Arraylist<>();
        mahasiswalist.add("Adi");
        mahasiswalist.add("Bambang");
        mahasiswalist.add("Cici");
        mahasiswalist.add("Didi");
        // lambda digunakan sebagai parameter
        mahasiswalist.forEach((nama) -> System.out.println(nama));
    }
}
