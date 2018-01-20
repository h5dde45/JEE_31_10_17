package tv_15_01.mltthr.p10;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App01 {
    public static void main(String[] args) throws InterruptedException {
        class Counter {
            int x = 0;
        }

        Counter counter = new Counter();
        Runnable runnable = () -> {
            for (int i = 0; i < 100_000; i++) {
                counter.x++;
            }
        };
        List<Thread> threads = Stream.generate(() -> new Thread(runnable))
                .limit(10)
                .peek(Thread::start)
                .collect(Collectors.toList());

        for (Thread thread:threads){
            thread.join();
        }

        System.out.println(counter.x);
    }
}

