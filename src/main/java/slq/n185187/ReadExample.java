package slq.n185187;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadExample {
    public static void main(String[] args) {
       String fPath=
               "C:\\java_projects\\july2017\\JEE_31_10_17\\src\\main\\java\\slq\\n185187\\in.txt";
        File file=new File(fPath);
        int simbol;
        try (FileReader reader=new FileReader(file)){
            while ((simbol=reader.read())!=-1){
                System.out.print(simbol+" "+(char)simbol+" ");
                Thread.sleep(500);
//                System.out.print((char)simbol);

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }
}
