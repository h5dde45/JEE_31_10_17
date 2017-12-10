package test.newthread.p16;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService service= Executors.newSingleThreadScheduledExecutor();
        service.schedule(new NewThread(),3, TimeUnit.SECONDS);
        service.shutdown();
    }
    static class NewThread extends Thread{
        @Override
        public void run() {
            System.out.println(1);
        }
    }
}
