package sourcecode.io;

import java.io.*;

public class App06 {
    public static void main(String[] args) {
        byte[] bytes = "new message".getBytes();
        System.out.println();

        try(
                InputStream is=new FileInputStream("src/main/java/sourcecode/io/in.txt");
                OutputStream out= new FileOutputStream("src/main/java/sourcecode/io/out.txt")
                ) {
            int read = is.read();
            while (read!=-1){
                System.out.print((char) read);
                out.write(read);
                read = is.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
