package test.newthread.p18;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(3);
        new Work(latch);
        new Work(latch);
        new Work(latch);

        latch.await();
        System.out.println("all job down");
    }
}
class Work extends Thread{
    CountDownLatch countDownLatch;

    public Work(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(1111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("down work");
        countDownLatch.countDown();
    }
}