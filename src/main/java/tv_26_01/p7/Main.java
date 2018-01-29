package tv_26_01.p7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> System.out.println("++++");
        runnable.run();

        run(() -> System.out.println("========="));

        Object obj = (Runnable) () -> System.out.println("-----");
        ((Runnable) obj).run();

        Runnable runnable1 = args.length > 0 ? () -> System.out.println(">") :
                () -> System.out.println("<");
        runnable1.run();

        IntSupplier intSupplier = () -> 3;
        System.out.println(intSupplier.getAsInt());
        System.out.println((new IntSupplier() {
            @Override
            public int getAsInt() {
                return 5;
            }
        }).getAsInt());

        IntSupplier intSupplier1 = new IntSupplier() {
            @Override
            public int getAsInt() {
//                while (true) {
//                }
                return 45;
            }
        };
        System.out.println(intSupplier1.getAsInt());

        IntBinaryOperator sum = new IntBinaryOperator() {
            @Override
            public int applyAsInt(int a, int b) {
                return Integer.sum(a, b);
            }
        };

        sum = Integer::sum;

        Function<String, String> trimmer = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.trim();
            }
        };

        Predicate<String> stringPredicate = s -> s.equals("asd");

        stringPredicate = "sdf"::equals;

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String x) {
                System.out.println(x);
            }
        };

        Supplier<List<String>> listSupplier = new Supplier<List<String>>() {
            @Override
            public List<String> get() {
                return new ArrayList<String>();
            }
        };

        IntFunction<String[]> intFunction = String[]::new;

        Consumer<Object> objectConsumer = o -> System.out.println(o);
        objectConsumer.accept(new Object());
        Consumer<Object> objectConsumer2 = System.out::println;
//        System.setOut(null);
        objectConsumer2.accept("333");
        objectConsumer.accept("333");

        System.out.println("++++++++++++++++++");

        Function<Integer, Integer> inc = bind(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return Integer.sum(a, b);
            }
        }, 3);
        System.out.println(inc.apply(7));

        System.out.println("+++++++++++");
        System.out.println(toInteger("34"));
        System.out.println(toInteger("34").get());
        System.out.println(toInteger("g4e"));
        Thread.sleep(1);
//        System.out.println(toInteger("g4e").get());
    }
    private static Optional<Integer> toInteger(String s){
        try {
            return Optional.of(Integer.parseInt(s));
        }catch (NumberFormatException e){
            return Optional.empty();
        }
    }

    private static <A, B, C> Function<B, C> bind(BiFunction<A, B, C> function, A a) {
        Objects.requireNonNull(function);
        return new Function<B, C>() {
            @Override
            public C apply(B b) {
                return function.apply(a, b);
            }
        };
    }

    private static void run(Runnable runnable) {
        runnable.run();
    }
}
