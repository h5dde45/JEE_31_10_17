package glvmthrd.n5;

public class App06 {

    public static void main(String[] args) throws InterruptedException {
        final Object monitor = new App06();

        new Thread(() -> {
            synchronized (monitor) {
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException ignore) {
                }
            }
        }).start();
        System.out.println("A");
        System.out.println("B");
        synchronized (monitor) {
            System.out.println("C");
        }

    }
}
