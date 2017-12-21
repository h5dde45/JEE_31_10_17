package glvmthrd.n4;

public class Main {
    static Object ref = new Object();
    static boolean run = true;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            synchronized (ref) {
                System.out.println(run);
                run = false;
            }
        });
        thread.start();
        while (run) {
            synchronized (ref) {
                System.out.println(run);
                try {
                    Thread.sleep(111);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
