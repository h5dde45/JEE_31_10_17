package glvmthrd.n9;

import java.util.concurrent.Executor;

public class Demo03 {
    public static void main(String[] args) {
        Executor executor = getExecutor();
        executor.execute(getTask());
        executor.execute(getTask());

        System.out.println(Thread.currentThread());
    }

    private static Executor getExecutor() {
        return new Executor() {
            @Override
            public void execute(Runnable command) {
                command.run();
            }
        };
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
