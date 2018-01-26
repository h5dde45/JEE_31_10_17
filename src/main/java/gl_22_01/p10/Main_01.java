package gl_22_01.p10;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_01 {
    public static void main(String[] args) {
        new Thread(Main_01::print).start();
        new Thread(() -> System.out.println("22222")).start();

       Arrays.asList("a", "bb", "ccc")
                .parallelStream()
                .map(String::length)
                .filter(integer -> integer % 2 == 1)
                .forEach(System.out::println);

        System.out.println("----------------");

//        HashSet<String> set = new HashSet<>(asList("eeee", "rrrrr"));
//        set.add("v");
//        set.add("bb");
//        set.add("nnn");

        Stream<Integer> iterate = Stream.iterate(1, integer -> integer * 2)
                .filter(r -> r % 2 == 0);
        iterate
                .limit(4)
                .map(integer -> " >> " + integer)
                .forEach(System.out::println);

        System.out.println("----------------");

        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Stream<String> stringStream = integerStream.map(integer -> "=>" + integer);
        List<String> collect = stringStream.collect(Collectors.toList());

        System.out.println(collect);
        Supplier<Double> random = Math::random;

    }

    private static void print() {
        System.out.println("11111111");
    }
}
