package tagval.u9;

import java.io.*;

public class IO {
    public static void main(String[] args) throws IOException {
//        byte[] bytes = new byte[10];
//        readFully(System.in, bytes);
//        System.out.println(Arrays.toString(bytes));

        InputStream inputStream = new FileInputStream(
                "C:\\java_projects\\july2017\\JEE_31_10_17\\" +
                        "src\\main\\java\\tagval\\u9\\data.txt");
//        byte[] bytes1 = inputStream.readAllBytes();
//        System.out.println(Arrays.toString(bytes1));

        InputStream inputStream2 = new FileInputStream(
                "C:\\java_projects\\july2017\\JEE_31_10_17\\" +
                        "src\\main\\java\\tagval\\u9\\data.txt");
        byte[] b = new byte[142];
//        int i = inputStream2.readNBytes(b, 4, 53);
//        System.out.println(i + " = " + Arrays.toString(b));

        InputStream inputStream3 = new FileInputStream(
                "C:\\java_projects\\july2017\\JEE_31_10_17\\" +
                        "src\\main\\java\\tagval\\u9\\data.txt");
        OutputStream outputStream = System.out;
//        inputStream3.transferTo(outputStream);

        System.out.println();

//        InputStream is = new URL("https://ya.ru/").openStream();
//        System.out.println(new String(is.readAllBytes(), StandardCharsets.UTF_8));
//
//        URL url = new URL("https://ya.ru/");
//        InputStream is2 = url.openConnection().getInputStream();
//        System.out.println(new String(is2.readAllBytes(), StandardCharsets.UTF_8));
        try(
        InputStream in=new FileInputStream("C:\\java_projects\\july2017\\" +
                "JEE_31_10_17\\src\\main\\java\\tagval\\u9\\data.txt");
        OutputStream out=new FileOutputStream("C:\\java_projects\\july2017\\" +
                "JEE_31_10_17\\src\\main\\java\\tagval\\u9\\out.txt");
        ){
//            in.transferTo(out);
        }

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
