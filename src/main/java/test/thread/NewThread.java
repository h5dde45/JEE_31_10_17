package test.thread;

import java.util.concurrent.*;

public class NewThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 7, 1L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(512));

        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

//        executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("runnable");
//            }
//        });
        executor.submit(() -> System.out.println("runnable"));

        Future<Boolean> future = executor.submit(() -> {
            String s = "+++";

            if ("+++".equals(s)) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        });
//        Future<Boolean> future = executor.submit(new Callable<Boolean>() {
//            @Override
//            public Boolean call() throws Exception {
//                String s = "+++";
//
//                if ("+++".equals(s)) {
//                    return Boolean.TRUE;
//                } else {
//                    return Boolean.FALSE;
//                }
//            }
//        });

        Boolean result=future.get(5,TimeUnit.SECONDS);

        if(result){
            System.out.println("ok");
        }
        executor.shutdown();

    }
}
