package tv_26_01.p8;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main02 {
    public static void main(String[] args) {
        List<List<String>> listList = Arrays.asList(
                Arrays.asList("foo", "bar", "baz"),
                Arrays.asList("asd", "zxc", "qwe"),
                Arrays.asList("rty", "vbn")
        );
        System.out.println(listList.stream()
        .flatMap(List::stream)
                .peek(System.out::println)
        .anyMatch("zxc"::equals));

        System.out.println(factorial(4));

        List<String> list = Arrays.asList("foo ", "  ", "  baz   ");
        List<String> list1 = progressList(list);
        System.out.println(list1);
    }

    private static List<String> progressList(List<String> list) {
        return list.stream()
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    private static BigInteger factorial(int i) {
        return IntStream.rangeClosed(1,i)
                .mapToObj(new IntFunction<BigInteger>() {
                    @Override
                    public BigInteger apply(int val) {
                        return BigInteger.valueOf(val);
                    }
                })
                .reduce(BigInteger.ONE, new BinaryOperator<BigInteger>() {
                    @Override
                    public BigInteger apply(BigInteger bigInteger, BigInteger val) {
                        return bigInteger.multiply(val);
                    }
                });
    }

}
