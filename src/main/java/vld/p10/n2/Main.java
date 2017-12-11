package vld.p10.n2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread worked = new WorkedThread();
//        worked.setDaemon(true);

        Thread sleeper = new SleepThread();
//        sleeper.setDaemon(true);

        System.out.println("Starting threads...");
        worked.start();
        sleeper.start();

        Thread.sleep(100);

//        System.out.println("interrupted threads...");
//        worked.interrupt();
//        sleeper.interrupt();

//        System.out.println("Joining threads...");
//        worked.join();
//        sleeper.join();

        System.out.println("all done");

    }

    private static class WorkedThread extends Thread {
        @Override
        public void run() {
            long sum = 0;
            for (int i = 0; i < 1e9; i++) {
                sum += i;
                if (i % 100 == 0 && isInterrupted()) {
                    System.out.println("loop interrupted at i=" + i);
                    break;
                }
            }
        }
    }

    private static class SleepThread extends Thread {
        @Override
        public void run() {
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
    }
}
