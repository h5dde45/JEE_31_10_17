package vl_20_01.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FJP {
    public static void main(String[] args) {
        int[] array = Comms.prepareArray();
        ForkJoinPool pool = new ForkJoinPool();
        long start = System.currentTimeMillis();
        double sum = pool.invoke(new RecursCalc(array, 0, array.length));
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " = " + sum);
        pool.shutdown();
    }

    private static class RecursCalc extends RecursiveTask<Double> {
        public static final int THE_MINIMUM_LIMIT_OF_THE_THREAD = 50_000;
        private final int[] ints;
        private final int start;
        private final int end;

        public RecursCalc(int[] ints, int start, int end) {
            this.ints = ints;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Double compute() {
            if (end - start <= THE_MINIMUM_LIMIT_OF_THE_THREAD) {
                return Comms.calc(ints, start, end);
            } else {
                int mid = start + (end - start) / 2;
                RecursCalc left = new RecursCalc(ints, start, mid);
                RecursCalc right = new RecursCalc(ints, mid, end);
                invokeAll(left,right);
                return left.join()+right.join();
            }
        }
    }
}
