package glvmthrd.n9;

import java.util.concurrent.*;

public class Demo00_Submit {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService= Executors.newCachedThreadPool();

        Future<Integer> future0 = executorService.submit(() -> 34);
        Future<Integer> future1 = executorService.submit(() -> {
            while (true){}
        });

        Thread.sleep(1000);
        System.out.println("future0.isDone(): "+future0.isDone());
        System.out.println("future1.isDone(): "+future1.isDone());
        System.out.println(future0.get(1, TimeUnit.SECONDS));
        System.out.println(future1.get());
    }
}
