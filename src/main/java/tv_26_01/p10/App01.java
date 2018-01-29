package tv_26_01.p10;

import java.util.ArrayList;

public class App01 {
    public static void main(String[] args) throws InterruptedException {
        Runnable foo=() -> {
            Container container = new Container();
            for (int i = 0; i < 100_000; i++) {
                container.addEntry("asd");
            }
        };
        ArrayList<Thread> listThread = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(foo);
            thread.start();
            listThread.add(thread);
        }

        for (Thread thread:listThread){
            thread.join();
        }
        System.out.println(Container.list.size());

    }
}
