package slq.n185187;

import java.io.*;

public class FileWriterExample {
    public static void main(String[] args) {
        String[] strings = {"one", "two", "4"};

        File fByte=new File("C:\\java_projects\\" +
                "july2017\\JEE_31_10_17\\src\\main\\java\\slq\\n185187\\byte.txt");

        File fSimbol=new File("C:\\java_projects\\" +
                "july2017\\JEE_31_10_17\\src\\main\\java\\slq\\n185187\\simbol.txt");

        try (
                FileOutputStream outputStream=new FileOutputStream(fByte);
                FileWriter writer=new FileWriter(fSimbol)
                ){
            for (String s:strings){
                outputStream.write(s.getBytes());
                writer.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
