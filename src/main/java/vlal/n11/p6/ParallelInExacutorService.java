package vlal.n11.p6;

import java.util.concurrent.*;

public class ParallelInExacutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] ints = Commons.prepareArrays();
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        long start = System.currentTimeMillis();
        Future<Double> future1 =
                executorService.submit(new PartialCalculator(ints, 0, ints.length / 2));
        Future<Double> future2 =
                executorService.submit(new PartialCalculator(ints,ints.length/2,ints.length));
        double sum = future1.get() + future2.get();
        double time = (System.currentTimeMillis() - start) / 1000.0;

        System.out.println("result = " + sum + ", during the " + time + " seconds");

        executorService.shutdown();

    }


    private static class PartialCalculator implements Callable<Double> {

        private final int[] array;
        private final int start;
        private final int end;

        public PartialCalculator(int[] array, int start, int end) {
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
