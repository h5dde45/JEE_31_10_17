package sourcecode.io;

import java.io.File;
import java.io.IOException;

public class App02 {
    public static void main(String[] args) throws IOException {
        String pathname = "C:\\java_projects\\july2017\\" +
                "JEE_31_10_17\\src\\main\\java\\" +
                "sourcecode\\io\\in.txt";
        File file=new File(pathname);
        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalFile());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canRead());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.isHidden());
        System.out.println(file.getTotalSpace()/10e9);
        System.out.println(file.getFreeSpace()/10e9);


    }
}
