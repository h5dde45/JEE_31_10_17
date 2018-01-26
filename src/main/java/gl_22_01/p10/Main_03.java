package gl_22_01.p10;

import java.util.stream.Stream;

public class Main_03 {
    public static void main(String[] args) {
        Stream<Double> generate = Stream.generate(Math::random);
        Stream<Integer> generate2 = Stream.iterate(1, t -> t + 1);

        Integer sum = generate2
                .parallel()
                .limit(4)
                .reduce(0, (integer, integer2) -> integer + integer2);

        System.out.println(sum);

    }
}
