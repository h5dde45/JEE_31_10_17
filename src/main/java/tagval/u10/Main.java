package tagval.u10;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable foo = () -> {
            Container container = new Container();
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
        System.out.println(Container.list.size());
    }

}

class Container {
    public static final List<String> list = new ArrayList<>(/*1000_000*/);

    synchronized void addEntry(String s) {
        list.add(s);
    }
}
