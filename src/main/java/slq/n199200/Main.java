package slq.n199200;

import java.io.InvalidObjectException;

public class Main {
    public static void main(String[] args) {
        Stud stud = new Stud("1111", "first", 34, "qwe");
        System.out.println(stud);
        System.out.println("=====================");

        String file = "C:\\java_projects\\july2017\\JEE_31_10_17\\src\\" +
                "main\\java\\slq\\n199200\\demo.data";
        Serialization serialization = new Serialization();
        System.out.println(serialization.serialization(stud, file));
        System.out.println("=====================");

        Stud.fclt="2222";
        System.out.println(stud);
        System.out.println("=====================");

        Stud result=null;

        try {
            result=serialization.deSerialization(file);
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        System.out.println("=====================");


    }
}
