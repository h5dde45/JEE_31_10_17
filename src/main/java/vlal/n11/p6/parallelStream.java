package vlal.n11.p6;

import java.util.Arrays;

public class parallelStream {
    public static void main(String[] args) {
        int[] ints = Commons.prepareArrays();
        long start = System.currentTimeMillis();
        double sum = Arrays.stream(ints)
                .parallel()
                .mapToDouble(Commons::function)
                .sum();
        double time = (System.currentTimeMillis() - start) / 1000.0;


        System.out.println("result = " + sum + ", during the " + time + " seconds");
    }
}
