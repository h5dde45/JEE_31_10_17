package vlal.n10;

public class Example01 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new NewThread().start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(new NewRunnable()).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> System.out.println(Thread.currentThread())).start();
        }
        System.out.println("main thread");
    }

    public static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println(getName() + " - " + currentThread());
        }
    }

    public static class NewRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread());

        }
    }
}
