package slq.n185187;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOExample {
    public static void main(String[] args) {
        String fPath = "C:\\java_projects\\july2017\\JEE_31_10_17" +
                "\\src\\main\\java\\slq\\n185187\\in.txt";
        String fResult = "C:\\java_projects\\july2017\\JEE_31_10_17" +
                "\\src\\main\\java\\slq\\n185187\\result.txt";

        try (
                FileInputStream fis = new FileInputStream(fPath);
                FileOutputStream fos = new FileOutputStream(fResult);
        ) {
            int symbol = fis.read();
            while (symbol != -1) {
                fos.write(symbol);
                symbol = fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
