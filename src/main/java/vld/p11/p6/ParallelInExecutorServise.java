package vld.p11.p6;

import java.util.concurrent.*;

public class ParallelInExecutorServise {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = Commons.prepareArray();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        long startTime = System.currentTimeMillis();

        Future<Double> future_1 =
                executor.submit(new Partial(array, 0, array.length / 2));
        Future<Double> future_2 =
                executor.submit(new Partial(array, array.length / 2, array.length));
        double sum=future_1.get()+future_2.get();

        System.out.println(sum);
        System.out.println(System.currentTimeMillis()-startTime);
        executor.shutdown();


    }

    private static class Partial implements Callable<Double> {
        private final int[] array;
        private final int start;
        private final int end;

        private Partial(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public Double call() throws Exception {
            return Commons.calculate(array,start,end);
        }
    }
}
