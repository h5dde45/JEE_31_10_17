package vld.p11.p5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor= Executors.newFixedThreadPool(2);
        System.out.println("submit worker 1");
        Future<String> future_1 = executor.submit(new Worker("worker_1"));
        System.out.println("submit worker 2");
        Future<String> future_2 = executor.submit(new Worker("worker_2"));

        System.out.println("Result from worker_1: "+future_1.get());
        System.out.println("Result from worker_1: "+future_2.get());
        System.out.println("==================");

        List<Future<String>> futures = executor.invokeAll(
                Arrays.asList(new Worker("worker_3"),
                        new Worker("worker_4"), new Worker("worker_5")));

        for(Future<String> future:futures){
            System.out.println(future.get());
        }
        executor.shutdown();
        executor.awaitTermination(10,TimeUnit.SECONDS);

    }

    private static class Worker implements Callable<String>{
        private final String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            long sleepTime= (long) (Math.random()*10_000L);
            System.out.println(name+" started, going to sleep for "+sleepTime);
            Thread.sleep(sleepTime);
            System.out.println(name+" finished");
            return name;
        }
    }
}
