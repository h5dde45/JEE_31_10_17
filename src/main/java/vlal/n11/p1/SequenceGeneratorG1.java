package vlal.n11.p1;

import java.util.ArrayList;

public class SequenceGeneratorG1 {
    private static  int counter = 0;

    public static synchronized int nextInt() {
        return counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1001; j++) {
                    nextInt();
                }
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(counter);
    }
}
