package tv_15_01.mltthr.p10;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Container container = new Container();

        Runnable foo = () -> {
            for (int i = 0; i < 100_000; i++) {
                container.addEntry("foo");
            }
        };

        ArrayList<Thread> threads = new ArrayList<>();
        for (long count = 10; count > 0; count--) {
            Thread thread = new Thread(foo);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(container.size());
    }
}
