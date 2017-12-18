package slq.n188189;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFilesExample {
    public static void main(String[] args) {
        String fPath="C:\\Users\\н\\Desktop\\message.txt";

        try (
                RandomAccessFile fileR=new RandomAccessFile(fPath,"r");
                RandomAccessFile fileRW=new RandomAccessFile(fPath,"rw");
                RandomAccessFile fileRW1=new RandomAccessFile(
                        "C:\\Users\\н\\Desktop\\message2.txt","rw")
                ){
            String tmp="";
            while ((tmp=fileR.readLine())!=null){
                System.out.println(tmp);
            }
            System.out.println("++++++++++++++++++++++++");

            fileR.seek(3);
            byte[] bytes = new byte[12];
            fileR.read(bytes);
            System.out.println(new String(bytes));
            System.out.println("++++++++++++++++++++++++");

            fileRW.seek(3);
            fileRW.write("* **".getBytes());

            fileRW1.seek(13);
            fileRW1.write("eerretye * **".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
