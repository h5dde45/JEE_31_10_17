package test.newthread.p23;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {
    static long numOfOperation = 10_000_000_000L;
    static int nos = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        System.out.println(nos);
        System.out.println(new Date());
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new NewFork(0, numOfOperation));
        System.out.println(new Date());
    }

    static class NewFork extends RecursiveTask<Long> {
        long from, to;

        public NewFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if ((to - from) <= numOfOperation / nos) {
                long j = 0;
                for (long i = from; i < to; i++) {
                    j += i;
                }
                return j;
            } else {
                long middle = (to + from) / 2;
                NewFork firstHalf = new NewFork(from, middle);
                firstHalf.fork();
                NewFork secondHalf = new NewFork(middle + 1, to);
                Long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;
            }
        }
    }
}
