package tv_15_01.mltthr.p11;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Doer {
    private volatile boolean flag = false;

    void doOnce(Runnable runnable) {
        if (!flag) {
            flag = true;
            runnable.run();
        }
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        final int threads = Runtime.getRuntime().availableProcessors();
        Doer doer = new Doer();
        CountDownLatch latch = new CountDownLatch(1);
        Runnable runnable = () -> {
            try {
                latch.await();
            } catch (InterruptedException ignore) {
            }
            doer.doOnce(() ->
                    System.out.println("In thread " + Thread.currentThread()));
        };
        List<Thread> list = Stream.generate(() -> new Thread(runnable))
                .limit(threads)
                .peek(Thread::start)
                .collect(Collectors.toList());
        latch.countDown();
        for (Thread thread : list) {
            thread.join();
        }
    }
}
