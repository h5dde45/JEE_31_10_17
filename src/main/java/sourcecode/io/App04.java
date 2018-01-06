package sourcecode.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class App04 {
    public static void main(String[] args) {
        byte[] bytes = "some text".getBytes();

        try (
                OutputStream os=new FileOutputStream(
//                        "C:\\java_projects\\july2017\\" +
//                                "JEE_31_10_17\\" +
                                "src\\main\\java\\sourcecode\\io\\out.txt")
                ){
            for (byte b:bytes) {
                os.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
