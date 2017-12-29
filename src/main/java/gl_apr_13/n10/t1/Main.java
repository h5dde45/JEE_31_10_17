package gl_apr_13.n10.t1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try (
                InputStream in = new URL("https://ya.ru").openStream();
                ByteArrayOutputStream out = new ByteArrayOutputStream()
        ) {
            copy(in, out);
            System.out.println(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void copy(InputStream in, OutputStream out) throws IOException {
        int k;
        while ((k = in.read()) != -1) {
            out.write(k);
        }
    }
}
