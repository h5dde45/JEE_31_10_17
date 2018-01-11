package vlal.n11.p5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("submit worker 1");
        Future<String> future1 = executor.submit(new Worker("worker1"));
        System.out.println("submit worker 2");
        Future<String> future2 = executor.submit(new Worker("worker2"));
        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println("++++++++++++++++++++");

        System.out.println("submit workers using invokeAll() ");
        List<Future<String>> futures = executor.invokeAll(Arrays.asList(new Worker("worker3"),
                new Worker("worker4"),
                new Worker("worker5")
        ));
        System.out.println("Exited invokeAll()");
        for (Future<String> future:futures){
            System.out.println(future.get());
        }
        executor.shutdown();
        executor.awaitTermination(10,TimeUnit.SECONDS);



    }
    private static  class Worker implements Callable<String>{
        private final String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            long sleepTime = (long) (Math.random() * 10_000);
            System.out.println(name+" started, going to sleep for "+sleepTime+"sc");
            Thread.sleep(sleepTime);
            System.out.println(name+" finished ");
            return name;
        }
    }
}
