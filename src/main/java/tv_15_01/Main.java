package tv_15_01;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        long start = System.nanoTime();
        long result = sumTwice(10_000_000);
        long end = System.nanoTime();
        System.out.printf("simple: %d, time=%8.3fms%n",//*fms%n
                result,(end-start)/1000_000.0);

        long startS = System.nanoTime();
        long resultS = sumTwiceStream(10_000_000);
        long endS = System.nanoTime();
        System.out.printf("stream: %d, time=%8.3fms%n",
                resultS,(endS-startS)/1000_000.0);

    }

    private static long sumTwice(int max) {
        long sum = 0;
        for (int i = 1; i <= max; i++) {
            sum += i * 2;
        }
        return sum;
    }

    private static long sumTwiceStream(int max) {
        return IntStream.rangeClosed(1, max)
                .mapToLong(value -> value * 2)
                .sum();
    }
}
