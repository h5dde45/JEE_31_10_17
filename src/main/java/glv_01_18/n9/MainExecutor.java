package glv_01_18.n9;

import java.util.concurrent.*;

public class MainExecutor {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        ExecutorService executor = Executors.newFixedThreadPool(
//                Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        executor.execute(getTask());
//        executor.execute(getTask());
//        executor.execute(getTask());

        Future<Integer> future0 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 42;
            }
        });

        Future<Integer> future1 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                while (true) {}
            }
        });

        Thread.sleep(1111);
        System.out.println("future0.isDone(): " + future0.isDone());
        System.out.println("future1.isDone(): " + future1.isDone());

        System.out.print("future0: " );
        System.out.println( future0.get());
        System.out.print("future1: ");
        System.out.println(future1.get());
        System.out.println("fin..");

    }

    private static Runnable getTask() {
        return () -> System.out.println(" >> " + Thread.currentThread());
    }
}
