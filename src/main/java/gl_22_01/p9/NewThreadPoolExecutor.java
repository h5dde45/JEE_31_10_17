package gl_22_01.p9;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class NewThreadPoolExecutor {
    public static void main(String[] args) {
        int corePoolSize = 4;
        int maximumPoolSize = 64;
        long keepAliveTime=10;
        TimeUnit unit = TimeUnit.SECONDS;

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(256);
        ThreadFactory threadFactory = new ThreadFactory() {
            AtomicInteger counter = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.NORM_PRIORITY);
                thread.setName("Thread #"+counter.incrementAndGet());
                return thread;
            }
        };

        RejectedExecutionHandler rejectedHandler =
                (r, executor) -> System.out.println("All thread busy + task queue is full");

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                keepAliveTime, unit, workQueue, threadFactory,
                rejectedHandler);

        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());

        executor.shutdown();
    }

    private static Runnable getTask() {
        return () -> System.out.println("From - "+Thread.currentThread());
    }
}
