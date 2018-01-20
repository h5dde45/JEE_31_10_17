package tv_15_01.mltthr.p10;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class App03 {
    public static void main(String[] args) throws InterruptedException {

        Queue<String> in = new ArrayDeque<>(Arrays.asList("qwe", "asd", "zxc"));
        Queue<String> out = new ArrayDeque<>(Arrays.asList("qwe", "asd", "zxc"));

        Thread thread_1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                System.out.println("Thread1: " + i);
                try {
                    transfer(in, out);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread_2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                System.out.println("Thread2: " + i);
                try {
                    transfer(out, in);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("Start...");
        thread_1.start();
        thread_2.start();
        thread_1.join();
        thread_2.join();
        System.out.println("Finish...");
    }

    static void transfer(Queue<String> in, Queue<String> out) throws InterruptedException {
        synchronized (in) {
            synchronized (out) {
                String result = in.poll();
                if (result != null) {
                    out.add(result);
                }
            }
        }
    }
}
