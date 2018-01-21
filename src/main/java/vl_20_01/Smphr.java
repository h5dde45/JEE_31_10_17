package vl_20_01;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Smphr {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2,true);
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            DeThread deThread = new DeThread(semaphore);
            threads.add(deThread);
            deThread.start();
        }
        Thread.sleep(20_000);
        for (Thread thread : threads) {
            thread.interrupt();
        }

    }

    private static class DeThread extends Thread {
        private final Semaphore semaphore;

        public DeThread(Semaphore semaphore) {
            this.semaphore = semaphore;
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
            while (true) {
                semaphore.acquire();
                try {
                    System.out.println(getName() + " acquired");
                    Thread.sleep(5001);
                } finally {
                    System.out.println(getName() + " releasing");
                    semaphore.release();
                }
            }
        }
    }
}
