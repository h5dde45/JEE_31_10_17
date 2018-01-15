package glv_01_18.n9;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        Executor executor0 = getExecutor();
        executor0.execute(getTask());
        executor0.execute(getTask());

        System.out.println(" From " + Thread.currentThread());

    }

    private static Executor getExecutor() {
        return new Executor() {
            private final AtomicLong aLong = new AtomicLong(0);
            private final ThreadGroup group = new ThreadGroup("NewGroup");

            @Override
            public void execute(Runnable command) {
                Thread thread = new Thread(group,command);
                thread.setPriority(Thread.NORM_PRIORITY+1);
//                thread.setDaemon(true);
                thread.setName("Thread #" + aLong.getAndIncrement());
                thread.start();
            }
        };
    }

    private static Runnable getTask() {
        return () -> System.out.println(" From " + Thread.currentThread());
    }
}
