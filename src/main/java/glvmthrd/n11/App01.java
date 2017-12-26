package glvmthrd.n11;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class App01 {
    public static void main(String[] args) {

        F<Integer> f = ( k, p) -> k + p;
        System.out.println(f.f(3,4));

        Stream.iterate(0L, aLong -> aLong + 1)
                .parallel()
                .filter(aLong -> aLong % 3 == 2)
                .map(aLong -> "= " + aLong)
                .limit(1)
                .forEach(s -> System.out.println(Thread.currentThread() + " >> " + s));

        Consumer<String> consumer=System.out::println;
        consumer.accept("ewrrf");

        new Thread(App01::fff).start();
    }

    private static void fff() {
        System.out.println("+++++++++++++++++++++");
    }
}

interface F<T> {
    T f(T k, T p);
}