package tv_26_01.p8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main01 {

    private static final String PREFIX = "__";

    public static void main(String[] args) {
        IntStream.range(1, 5)
                .boxed()
                .sorted(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return Math.random() > 0.5 ? 1 : -1;
                    }
                })
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer x) {
                        System.out.println(x);
                    }
                });

        System.out.println("==========================");

        List<Integer> list = IntStream.range(1, 12)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(list);
        list.forEach(System.out::println);
        System.out.println("==========================");

        IntStream.iterate(1, operand -> operand * 2)
                .limit(10)
                .sorted()
                .forEach(System.out::println);

        System.out.println("++++++++++++++++++++++");
        long count = Stream.of(3.3, 4.5, 4.4)
                .filter(aDouble -> aDouble > 4.43)
                .count();
        System.out.println(count);

        System.out.println("++++++++++++++++++++++");
        long count1 = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .peek(System.out::println)
                .count();

        System.out.println("++++++++++++++++++++++");
        Stream.of("rf", "__wer", "erev")
                .filter(s -> s.startsWith(PREFIX))
                .findFirst()
                .map(s -> s.substring(PREFIX.length()))
                .ifPresent(s -> System.out.println("option supplied: " + s));

        System.out.println(Stream.of("rf", "__wer", "erev")
        .anyMatch(s -> s.startsWith(PREFIX)));

    }

}
