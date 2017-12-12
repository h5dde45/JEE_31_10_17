package vld.p11.n1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGeneratorBroken {
    //#1
//    private static volatile int counter = 0;
//    public static int nextInt() {
//        return counter++;
//    }
    //#2
//    private static  int counter = 0;
//    public static synchronized int nextInt() {
//        return counter++;
//    }
    //#3
    private static final AtomicInteger counter = new AtomicInteger();
    public static int nextInt() {
        return counter.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    nextInt();
                }
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread thread:threads){
            thread.join();
        }
        System.out.println(counter);
    }
}
