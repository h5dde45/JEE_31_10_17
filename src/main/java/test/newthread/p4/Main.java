package test.newthread.p4;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger atomicInteger=new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 10_000; j++) {
            new NewThread().start();
        }
        Thread.sleep(2000);
        System.out.println(atomicInteger);
    }
    static class NewThread extends Thread{
        @Override
        public void run() {
            atomicInteger.incrementAndGet();
        }
    }
}
