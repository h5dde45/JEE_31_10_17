package gl_apr_13.n10.t1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class App01 {
    public static void main(String[] args) throws IOException {
        try (
                InputStream in = new URL("https://ya.ru").openStream();
                ByteArrayOutputStream out = new ByteArrayOutputStream()
        ) {
            copy(in, out);
            System.out.println(out);
        }

    }

    private static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buff=new byte[64];
        int count;
        while ((count = in.read(buff)) != -1) {
            out.write(buff,0 ,count);
        }
    }
}
