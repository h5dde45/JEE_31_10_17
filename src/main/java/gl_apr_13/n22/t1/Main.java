package gl_apr_13.n22.t1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String data = "a bb abb bad bb cad bab a XY YX XY";
        String[] split = data.split(" ");

        System.out.println(Arrays.toString(split));

        Scanner scanner = new Scanner(data);

        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }


    }
}
