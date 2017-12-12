package vld.p11.p6;

import java.util.Arrays;

public class ParallelStream {
    public static void main(String[] args) {
        int[] ints = Commons.prepareArray();
        long start = System.currentTimeMillis();

        double sum = Arrays.stream(ints).parallel().mapToDouble(Commons::function).sum();

        System.out.println(sum);
        System.out.println(System.currentTimeMillis()-start);

    }
}
