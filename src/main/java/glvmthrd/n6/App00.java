package glvmthrd.n6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App00 {
    public static void main(String[] args) {
        BlockingQueue<String> queue=new ArrayBlockingQueue<>(16);

        //producer
        new Thread(() -> {
            int counter = 0;
            while (true) {
                try {
                    Thread.sleep(1111);
                    queue.put(++counter+"");
                    System.out.println("put: "+counter);
                } catch (InterruptedException ignore) {}
            }
        }).start();

        //consumer
        new Thread(() -> {
            while (true) {
                String data;
                try {
                    System.out.println(".....to wait to take");
                    data = queue.take();//block thread
                    System.out.println("take: " + data);
                } catch (InterruptedException ignore) {}
            }
        }).start();
    }
}
