package gl_22_01.p9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewExecutors {
    public static void main(String[] args) {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());

        executor.shutdown();

    }
    private static Runnable getTask() {
        return () -> System.out.println("From - "+Thread.currentThread());
    }
}
