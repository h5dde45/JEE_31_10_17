package vl_20_01;

import java.util.ArrayList;

public class SeqGenBroken {
    private static volatile int count = 0;

    public static int next() {
        return count++;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    next();
                }
            });
            thread.start();
            threadList.add(thread);
        }

        for (Thread thread:threadList){
            thread.join();
        }

        System.out.println(count);
    }

}
