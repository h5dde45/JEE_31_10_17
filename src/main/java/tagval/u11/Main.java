package tagval.u11;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    private volatile boolean flag = false;
    private final AtomicBoolean flag2=new AtomicBoolean(false);

    public static void main(String[] args) {
        Main main = new Main();
        Runnable runnable = () -> System.out.println("++++++");
        for (int i = 0; i < 4; i++) {
            main.doOnce(runnable);
            main.doOnce2(runnable);
        }
    }

     void doOnce(Runnable action) {
        if (!flag) {
            flag = true;
            action.run();
        }
    }
    void doOnce2(Runnable action){
        if(flag2.compareAndSet(false,true)){
            action.run();
        }
    }
}
