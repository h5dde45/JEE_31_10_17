package glvmthrd.n11;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class App10 {
    public static void main(String[] args) {
        Supplier<Double> s = Math::random;
        Function<String, Integer> f = Integer::parseInt;
        Predicate<Double> p = aDouble -> aDouble > 33;

        System.out.println(s.get());
        System.out.println(f.apply("345"));
        System.out.println(p.test(-67d));

        System.out.println("===========");
        Function<String,Stream<String>> function=new Function<String, Stream<String>>() {
            @Override
            public Stream<String> apply(String s) {
                return Arrays.stream(s.split(" "));
            }
        };

        Stream.of("1", "2 33", "4 55 666")
        .flatMap(function)
                .forEach(System.out::println);


    }
}
