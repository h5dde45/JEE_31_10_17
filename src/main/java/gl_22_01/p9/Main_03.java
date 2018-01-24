package gl_22_01.p9;

import java.util.concurrent.Executor;

public class Main_03 {
    public static void main(String[] args) throws InterruptedException {
        Executor executor = new NewThreadPool(2);
        executor.execute(getTask());
//        Thread.sleep(11);
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
        System.out.println("main ended");
    }
    private static Runnable getTask() {
        return () -> System.out.println("From - " + Thread.currentThread());
    }
}
