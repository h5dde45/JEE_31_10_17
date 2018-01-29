package av29_01.p11.d1;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main01 {
private static /*volatile*/ AtomicInteger counter =new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10_004; j++) {
                    nextInt();
                }
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread thread:threads){
            thread.join();
        }

        System.out.println(counter);
    }

    private /*synchronized*/ static int nextInt() {
        return counter.getAndIncrement();

    }

}
