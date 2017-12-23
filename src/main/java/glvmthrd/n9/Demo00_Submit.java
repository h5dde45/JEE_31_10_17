package glvmthrd.n9;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo00_Submit {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();

        Future<Integer> future0 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 34;
            }
        });
        Future<Integer> future1 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                while (true){}
            }
        });

        Thread.sleep(1000);
        System.out.println("future0.isDone(): "+future0.isDone());
        System.out.println("future1.isDone(): "+future1.isDone());
    }
}
