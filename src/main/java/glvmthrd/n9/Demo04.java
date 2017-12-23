package glvmthrd.n9;

import java.util.concurrent.Executor;

public class Demo04 {
    public static void main(String[] args) {
        Executor executor = new NewThreadPool(2);
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());

    }


    private static Runnable getTask() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("====" + Thread.currentThread());
            }
        };
    }
}
