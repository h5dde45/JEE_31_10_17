package glv_01_18.n9;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

public class NewPool implements Executor {
    private final BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<>(256);
    private final Thread[] pool;

    public NewPool(int threadCount) {
        this.pool = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            pool[i] = new Thread(() -> {
                while (true) {
                    try {
                        Runnable nextTask = taskQueue.take();
                        nextTask.run();
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            });
            pool[i].start();
        }
    }


    @Override
    public void execute(Runnable command) {
        if (!taskQueue.offer(command)) {
            System.out.println("rejected...");
        }

//        try {
//            taskQueue.put(command);
//        } catch (InterruptedException e) {
//            throw new Error("never", e);
//        }

//        try {
//            taskQueue.add(command);
//        } catch (IllegalArgumentException e) {
//            System.out.println("rejected...");
//        }
    }
}
