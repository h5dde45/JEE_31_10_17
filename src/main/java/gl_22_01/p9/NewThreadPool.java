package gl_22_01.p9;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;

public class NewThreadPool implements Executor {
//    private final BlockingQueue<Runnable> taskQueue =
//            new ArrayBlockingQueue<>(256);
    private final BlockingQueue<Runnable> taskQueue =
            new LinkedBlockingDeque<>(1);
    private final Thread[] pool;

    public NewThreadPool(int threadCount) {
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
//        if (!taskQueue.offer(command)) {
//            System.out.println("rejected");
//        }

        try {
            taskQueue.put(command);
        } catch (InterruptedException e) {
            throw new Error("never",e);
        }

//        try {
//            taskQueue.add(command);
//        }catch (IllegalStateException e){
//            System.out.println("rejected");
//        }
    }
}
