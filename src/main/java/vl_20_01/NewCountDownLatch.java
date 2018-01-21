package vl_20_01;

import java.util.concurrent.CountDownLatch;

public class NewCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new DemoNewThread(latch).start();
        }
    }

    private static class DemoNewThread extends Thread {
        private final CountDownLatch latch;

        public DemoNewThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                runUS();
            } catch (InterruptedException e) {
                System.out.println(getName() + "interrupted");
            }
        }

        private void runUS() throws InterruptedException {
            Thread.sleep((long) (Math.random() * 10_000));
            System.out.println(getName() + " finish init");
            latch.countDown();
            latch.await();
            System.out.println(getName() + " entered");

            Thread.sleep((long) (Math.random() * 10_000));

        }
    }
}
