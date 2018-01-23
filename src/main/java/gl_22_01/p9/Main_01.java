package gl_22_01.p9;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public class Main_01 {
    public static void main(String[] args) {
        Executor executor = getExecutor();
        executor.execute(getTask());
        executor.execute(getTask());
        System.out.println(" Main " + Thread.currentThread());
    }

    private static Executor getExecutor() {
        return new Executor() {
            private final AtomicLong index=new AtomicLong(0);
            private final ThreadGroup group=new ThreadGroup("NewGroup");
            @Override
            public void execute(Runnable command) {
                Thread thread = new Thread(group,command);
                thread.setPriority(Thread.NORM_PRIORITY+1);
                thread.setDaemon(false);
                thread.setName("Thread #"+index.getAndIncrement());
                thread.start();
            }
        };
    }

    private static Runnable getTask() {
        return () -> {
            Thread thread = Thread.currentThread();
            System.out.println(" from " + thread);
        };
    }
}
