package gl_apr_13.n13.t2;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] names = new File(
                "C:\\java_projects\\july2017\\" +
                        "JEE_31_10_17\\src\\main\\java\\gl_apr_13\\" +
                        "").list();
        System.out.println(Arrays.toString(names));
    }
}
