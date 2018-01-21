package vl_20_01.fork;

import java.util.concurrent.*;

public class ParInExeService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = Comms.prepareArray();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        long start = System.currentTimeMillis();
        Future<Double> future_1 = executorService.submit(new PartCalc(array, 0, array.length / 2));
        Future<Double> future_2 = executorService.submit(new PartCalc(array, array.length / 2, array.length));
        double sum = future_1.get() + future_2.get();
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " = " + sum);
        executorService.shutdown();
    }

    private static class PartCalc implements Callable<Double> {
        private final int[] ints;
        private final int start;
        private final int end;

        public PartCalc(int[] ints, int start, int end) {
            this.ints = ints;
            this.start = start;
            this.end = end;
        }

        @Override
        public Double call() throws Exception {
            return Comms.calc(ints, start, end);
        }
    }
}
