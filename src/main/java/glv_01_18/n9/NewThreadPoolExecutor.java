package glv_01_18.n9;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class NewThreadPoolExecutor {
    public static void main(String[] args) {
        int corePoolSize = 4;
        int maxPoolSize = 64;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(256);

        ThreadFactory threadFactory = new ThreadFactory() {
            private AtomicInteger counter = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.NORM_PRIORITY);
                thread.setName("NewPool_NormPriority-" + counter.incrementAndGet());
                return thread;
            }
        };
        RejectedExecutionHandler rejectedHandler = new RejectedExecutionHandler() {

            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("all thread busy + task queue is full");
            }
        };
        Executor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, rejectedHandler);
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
    }

    private static Runnable getTask() {
        return () -> System.out.println(" >> " + Thread.currentThread());
    }
}
