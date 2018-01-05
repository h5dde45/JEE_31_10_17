package tagval.u9;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class IO {
    public static void main(String[] args) throws IOException {
//        byte[] bytes = new byte[10];
//        readFully(System.in, bytes);
//        System.out.println(Arrays.toString(bytes));

        InputStream inputStream = new FileInputStream(
                "C:\\java_projects\\july2017\\JEE_31_10_17\\" +
                        "src\\main\\java\\tagval\\u9\\data.txt");
        byte[] bytes1 = inputStream.readAllBytes();
        System.out.println(Arrays.toString(bytes1));

        InputStream inputStream2 = new FileInputStream(
                "C:\\java_projects\\july2017\\JEE_31_10_17\\" +
                        "src\\main\\java\\tagval\\u9\\data.txt");
        byte[] b = new byte[142];
        int i = inputStream2.readNBytes(b, 4, 53);
        System.out.println(i + " = " + Arrays.toString(b));

        InputStream inputStream3 = new FileInputStream(
                "C:\\java_projects\\july2017\\JEE_31_10_17\\" +
                        "src\\main\\java\\tagval\\u9\\data.txt");
        OutputStream outputStream=System.out;
        inputStream3.transferTo(outputStream);


    }

    private static void readFully(InputStream is, byte[] bytes) throws IOException {
        int offset = 0;
        while (offset < bytes.length) {
            int count = is.read(bytes, offset, bytes.length - offset);
            if (count == -1) {
                throw new IOException("Stream has less than " + bytes.length + " bytes");
            }
            offset += count;
            System.out.println(offset);
        }

    }
}
