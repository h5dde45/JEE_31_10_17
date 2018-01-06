package alma;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Integer i = 20111;
        Class<? extends Integer> aClass = i.getClass();
        System.out.println(aClass);

        Stream.of(Person.class.getDeclaredMethods())
                .forEach(System.out::println);
    }
}
