package gl_22_01.p9;

import java.util.concurrent.*;

public class Submit {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<?> future_0 = executorService.submit(() -> 55);

        Future<?> future_1 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                while (true) ;
            }
        });

        Thread.sleep(1000);

        System.out.println(future_0.isDone());
        System.out.println(future_1.isDone());
        System.out.println(future_0.get());
        System.out.println(future_1.get());
        System.out.println("Main ended");
    }
}
