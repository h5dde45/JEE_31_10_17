package vl_20_01;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SeqGenOk_2 {
    private static final AtomicInteger count = new AtomicInteger(0);

    public static int next() {
        return count.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int k = 0; k < 1000; k++) {
                    next();
                    ;
                }
            });
            thread.start();
            threadList.add(thread);
        }

        for (Thread thread:threadList){
            thread.join();
        }

        System.out.println(count);
    }

}
