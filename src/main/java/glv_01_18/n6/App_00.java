package glv_01_18.n6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App_00 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(16);

        for (int i = 0; i < 3; i++) {
            //producer
            int finalI = i;
            new Thread(() -> {
                int counter = 0;
                while (true) {
                    try {
                        Thread.sleep(1000*finalI+300);
                        queue.put(++counter + "");
                        System.out.println("put: "+ finalI +" = " + counter);
                    } catch (InterruptedException ignore) {
                    }
                }
            }).start();

            //consumer
            new Thread(() -> {
                while (true) {
                    try {
                        String data = queue.take();
                        System.out.println("take: "+ finalI +" = "  + data);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
