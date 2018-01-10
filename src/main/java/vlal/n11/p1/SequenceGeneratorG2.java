package vlal.n11.p1;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGeneratorG2 {
    private static AtomicInteger counter =new AtomicInteger();

    public static int nextInt() {
        return counter.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1003; j++) {
                    nextInt();
                }
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(counter.get());
    }
}
