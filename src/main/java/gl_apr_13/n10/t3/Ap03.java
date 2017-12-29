package gl_apr_13.n10.t3;

import java.io.*;
import java.net.URL;

public class Ap03 {
    public static void main(String[] args) throws IOException {
        try (
                InputStream in = new URL("https://yandex.ru/").openStream();
                NewOutputStream out = new NewOutputStream(new FileOutputStream(
                        "C:\\java_projects\\july2017\\JEE_31_10_17\\" +
                                "src\\main\\java\\gl_apr_13\\n10\\t3\\text.txt"))
        ) {
            copy(in, out);

        }
    }

    private static void copy(InputStream in, NewOutputStream out) throws IOException {
        byte[] buff=new byte[13164];
        int count;
        while ((count = in.read(buff)) != -1) {
            out.write(buff,0 ,count);
        }

    }

    private static class NewOutputStream extends OutputStream {
        private OutputStream out;

        public NewOutputStream(OutputStream outputStream) {
            out = outputStream;
        }

        @Override
        public void write(int b) throws IOException {
            out.write(b);
            System.out.println(1);
        }

        @Override
        public void write(byte[] b) throws IOException {
            out.write(b);
            System.out.println(b.length);
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            out.write(b, off, len);
            System.out.println(len-off);
        }
    }
}
