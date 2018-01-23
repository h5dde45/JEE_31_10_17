package gl_22_01.p9;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

public class NewThreadool implements Executor {
    private final BlockingQueue<Runnable> taskQueue =
            new ArrayBlockingQueue<Runnable>(256);
    private final Thread[] pool;

    public NewThreadool(int threadCount) {
        this.pool = new Thread[threadCount];

    }

    @Override
    public void execute(Runnable command) {

    }
}
