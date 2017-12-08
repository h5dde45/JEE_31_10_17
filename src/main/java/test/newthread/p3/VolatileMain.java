package test.newthread.p3;

public class VolatileMain {
    private volatile static int i;

    public static void main(String[] args) {
        new ReadThread().start();
        new WriteThread().start();


    }

    static class WriteThread extends Thread {
        @Override
        public void run() {
            while (i < 5) {
                System.out.println("increment " + ++i);
                try {
                    Thread.sleep(1111);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ReadThread extends Thread {
        @Override
        public void run() {
            int localeVar = i;
            while (localeVar < 5) {
                if (localeVar != i) {
                    System.out.println("value " + i);
                    localeVar = i;
                }
            }
        }
    }
}
