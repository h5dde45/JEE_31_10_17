package vl_20_01;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExeSerNew {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        System.out.println("Submit w_1");
        Future<String> future_01 = executor.submit(new NewWorker("worker_01"));
        System.out.println("Submit w_2");
        Future<String> future_02 = executor.submit(new NewWorker("worker_02"));

        System.out.println("result w1: "+future_01.get());
        System.out.println("result w2: "+future_02.get());

        System.out.println("###########################");

        System.out.println("invokeAll");

        List<Future<String>> futures = executor.invokeAll(
                Arrays.asList(new NewWorker("worker_03"),
                        new NewWorker("worker_04"),
                        new NewWorker("worker_05")));

        System.out.println("exited all");
        for (Future<String> future:futures){
            System.out.println(future.get());
        }

        executor.shutdown();
        executor.awaitTermination(10,TimeUnit.SECONDS);

    }

    private static class NewWorker implements Callable<String> {
        private final String name;

        public NewWorker(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            long sleepTime = (long) (Math.random() * 10000);
            System.out.println(name + " start, going to sleep for " + Thread.currentThread());
            Thread.sleep(sleepTime);
            System.out.println(name + " finished");
            return name;
        }
    }
}
