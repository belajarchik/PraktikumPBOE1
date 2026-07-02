
import java.util.ArrayList;

public class LambdaList {
    public static void main(String[] args) {

        ArrayList<String> mahasiswalist = new ArrayList<>();
        mahasiswalist.add("Adi");
        mahasiswalist.add("Bambang");
        mahasiswalist.add("Cici");
        mahasiswalist.add("Didi");
        // lambda digunakan sebagai parameter
        mahasiswalist.forEach((nama) -> System.out.println(nama));
    }
}
