package glv_01_18.n9;

import java.util.concurrent.Executor;

public class AppThreadPool {
    public static void main(String[] args) {
        Executor executor = new NewPool(2);
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
    }

    private static Runnable getTask() {
        return () -> System.out.println(" >> " + Thread.currentThread());
    }
}
