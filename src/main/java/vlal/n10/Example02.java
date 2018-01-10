package vlal.n10;

public class Example02 {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new WorkerThread();
        SleeperThread sleeper = new SleeperThread();
        worker.setDaemon(true);
        sleeper.setDaemon(true);

        System.out.println("start threads");
        worker.start();
        sleeper.start();

        Thread.sleep(100);

//        System.out.println("interrupting threads");
//        worker.interrupt();
//        sleeper.interrupt();
//
//        System.out.println("join");
//        worker.join();
//        sleeper.join();

        System.out.println("all done");

    }

    private static class WorkerThread extends Thread {
        @Override
        public void run() {
            long sum = 0;
            for (int i = 0; i < 1000_000_000; i++) {
                sum += i;
                if (i % 100 == 0 && isInterrupted()) {
                    System.out.println("i= " + i);
                    break;
                }
            }
        }
    }

    private static class SleeperThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
    }
}
