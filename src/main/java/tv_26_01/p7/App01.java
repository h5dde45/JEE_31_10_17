package tv_26_01.p7;

import java.util.Optional;

public class App01 {
    public static void main(String[] args) {
        Optional<String> foo = Optional.of("foo");
        Optional<String> s = foo.
                filter("foo"::equals);
        boolean present = s
                .isPresent();
        System.out.println(present);

        String s1 = Optional.of("  foo  ")
                .map(String::trim).get();
        System.out.println(s1);

        Integer integer=Optional.of("123456").flatMap(App01::toInteger).orElse(-1);
        System.out.println(integer);

    }

    private static  Optional<Integer> toInteger(String s2) {
        return Optional.ofNullable(Integer.parseInt(s2));
    }
}
