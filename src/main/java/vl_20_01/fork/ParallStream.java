package vl_20_01.fork;

import java.util.Arrays;

public class ParallStream {
    public static void main(String[] args) {
        int[] ints = Comms.prepareArray();
        long start = System.currentTimeMillis();
        double sum = Arrays.stream(ints)
                .parallel()
                .mapToDouble(Comms::func)
                .sum();
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " = " + sum);
    }
}
