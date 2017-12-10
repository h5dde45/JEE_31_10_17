package test.newthread.p15;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new NewRunnable());
        Future<String> submit = executorService.submit(new NewCallable());
        System.out.println(submit.get());
        executorService.shutdown();
    }

    static class NewRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(1);
        }
    }

    static class NewCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "2";
        }
    }
}
