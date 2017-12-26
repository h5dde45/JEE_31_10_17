package glvmthrd.n11;

import java.util.Optional;
import java.util.stream.Stream;

public class Main03 {
    public static void main(String[] args) {
        Optional<Integer> sum =
                Stream.iterate(1, k -> k + 1)
//                        .parallel()
                        .limit(10)
                        .reduce((integer, integer2) -> integer + integer2);

        System.out.println(sum);
        ;
    }
}
