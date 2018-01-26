package gl_22_01.p10;

import java.util.function.Function;
import java.util.stream.Stream;

public class Main_02 {
    public static void main(String[] args) {
        Function<String, Stream<String>> f = s -> Stream.of(s.split(" "));

        Stream.of("1", "22 333", "4444 55555 666666")
                .flatMap(f)
                .forEach(System.out::println);
    }
}
