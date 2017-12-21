package glvmthrd.n5;

public class App05 {
    static volatile boolean in = false;

    public static void main(String[] args) {
        final Object monitor = new App05();

        new Thread(() -> {
            synchronized (monitor) {
                in = true;
                //                    Thread.sleep(Long.MAX_VALUE);
                try {
                    System.out.println("1");
                    monitor.wait();
                    System.out.println("2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("---");
            }
        }).start();

        System.out.println("A");
        while (!in) ;
        System.out.println("B");
        synchronized (monitor) {
            System.out.println("C");
            monitor.notify();
            System.out.println("R");
        }
        System.out.println("F");

    }
}
