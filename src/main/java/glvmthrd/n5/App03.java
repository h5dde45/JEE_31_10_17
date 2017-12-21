package glvmthrd.n5;

public class App03 {
    public static void main(String[] args) {
        final Object monitor0 = new App03();
        final Object monitor1 = new App03();
        new Thread(() -> {
            System.out.println("a");
            synchronized (monitor0) {
                while (true) {
                    try {
                        Thread.sleep(1111);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A");
                }
            }
        }).start();
        new Thread(() -> {
            System.out.println("b");
            synchronized (monitor1) {
                while (true) {
                    try {
                        Thread.sleep(1111);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("B");
                }
            }
        }).start();
    }
}
