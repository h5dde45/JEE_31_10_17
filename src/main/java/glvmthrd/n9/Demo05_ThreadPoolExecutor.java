package glvmthrd.n9;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo05_ThreadPoolExecutor {
    public static void main(String[] args) {
        int corePoolSize=4;
        int maximumPoolSize=64;
        long keepAliveTime=10;
        TimeUnit unit=TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue= new ArrayBlockingQueue<>(256);
        ThreadFactory threadFactory=new ThreadFactory() {
            private AtomicInteger counter=new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                Thread thread=new Thread(r);
                thread.setPriority(Thread.NORM_PRIORITY);
                thread.setName("Pool-NormPriority"+counter.incrementAndGet());
                return thread;
            }
        };

        RejectedExecutionHandler rejectedHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("All thread busy + task queue is full");
            }
        };

        Executor executor=new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,unit,
                workQueue,
                threadFactory,
                rejectedHandler
        );

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
