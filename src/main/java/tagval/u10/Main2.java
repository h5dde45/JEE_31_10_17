package tagval.u10;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Container2 container = new Container2();
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

        System.out.println(container.list.size());
        while (container.size() < 1000_000) {

        }
        System.out.println("finished....");

    }

}

class Container2 {
    public final List<String> list = new ArrayList<>();

    synchronized void addEntry(String s) {
        list.add(s);
    }

    synchronized int size() {
        return list.size();
    }
}
