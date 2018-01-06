package sourcecode.io;

import java.io.File;
import java.io.IOException;

public class App03 {
    public static void main(String[] args) throws IOException {
        String pathname = "src\\main\\java\\sourcecode\\io/backup";
        File dir = new File(pathname);
        if (!dir.exists()) {
            System.out.println(dir.mkdir());
        }
        if (dir.isDirectory()) {
            String[] content = dir.list();
            if (content != null) {
                for (String s : content) {
                    File file = new File(pathname + "/" + s);
                    System.out.println(file.isDirectory()?
                    file+" - dir": file+ " - file");
                }
            }
        }


    }
}
