package glvmthrd.n3;

public class App00_norm {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
        });
        thread.start();

        thread.join();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
