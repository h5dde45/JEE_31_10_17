package gl_22_01.p10;

import java.util.Arrays;

public class Main_01 {
    public static void main(String[] args) {
        new Thread(Main_01::print).start();
        new Thread(() -> System.out.println("22222")).start();

        Arrays.asList("a","bb","ccc")
                .parallelStream()
                .map(s -> s.length())
                .filter(integer -> integer%2==1)
                .forEach(System.out::println);

    }
    private static void print(){
        System.out.println("11111111");
    }
}
