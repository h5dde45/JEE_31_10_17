package vlal.n11.p6;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolEx {
    public static void main(String[] args) {
        int[] ints = Commons.prepareArrays();
        ForkJoinPool pool = new ForkJoinPool();
        long start = System.currentTimeMillis();
        double sum = pool.invoke(new RecursiveCalculate(ints, 0, ints.length));
        double time = (System.currentTimeMillis() - start) / 1000.0;

        System.out.println("result = " + sum + ", during the " + time + " seconds");

        pool.shutdown();
    }

    private static class RecursiveCalculate extends RecursiveTask<Double> {
        private static final int SEQUENTIAL_THRESHOLD = 50_000;
        private final int[] array;
        private final int start;
        private final int end;

        public RecursiveCalculate(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Double compute() {
            if (end - start <= SEQUENTIAL_THRESHOLD) {
                return Commons.calculate(array, start, end);
            } else {
                int mid = start + (end - start) / 2;
                RecursiveCalculate left = new RecursiveCalculate(array, start, mid);
                RecursiveCalculate right = new RecursiveCalculate(array, mid, end);
                invokeAll(left,right);
                return left.join()+right.join();
            }
        }
    }
}
