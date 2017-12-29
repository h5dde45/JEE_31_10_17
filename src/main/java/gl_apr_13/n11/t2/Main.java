package gl_apr_13.n11.t2;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
//        try (
//            Writer write0 =
//                    new OutputStreamWriter(
//                            new FileOutputStream(
//                                    new File("C:\\java_projects\\" +
//                                            "july2017\\JEE_31_10_17\\src\\main\\" +
//                                            "java\\gl_apr_13\\n11\\t2\\data.txt")), "utf-8");
//            ){
//            write0.write(new char[]{'d', 'u', 'D'});
//        }
//
//        try (
//        Writer write1 =
//                new FileWriter(
//                        new File("C:\\java_projects\\" +
//                                "july2017\\JEE_31_10_17\\src\\main\\" +
//                                "java\\gl_apr_13\\n11\\t2\\data1.txt"));
//        ) {
//            write1.write(new char[]{'d', 'u', 'D'});
//        }
//
//
        File file = new File("C:\\java_projects\\july2017\\JEE_31_10_17\\src\\" +
                "main\\java\\gl_apr_13\\n11\\t2\\data3.txt");

        try(
                FileOutputStream outputStream = new FileOutputStream(file);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                GZIPOutputStream gzipOutputStream=new GZIPOutputStream(bufferedOutputStream);
                DataOutputStream dataOutputStream = new DataOutputStream(gzipOutputStream)
                ) {
            for (int i = 0; i < 1000; i++) {
                dataOutputStream.writeDouble(12e3);
            }
        }

        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
                GZIPInputStream gzipInputStream=new GZIPInputStream(bufferedInputStream);
                DataInputStream dataInputStream=new DataInputStream(gzipInputStream)
                ){
            System.out.println(dataInputStream.readDouble());
            System.out.println(dataInputStream.readDouble());
            System.out.println(dataInputStream.readDouble());
        }

    }
}
