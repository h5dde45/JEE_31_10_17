package glvmthrd.n4;

public class D {
    static boolean run = true;

    public static synchronized boolean isRun() {
        return run;
    }

    public static /*synchronized*/ void setRun(boolean run) {
        D.run = run;
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            setRun(false);
        });
        thread.start();
        while (isRun()) {
            System.out.println(isRun());
            try {
                Thread.sleep(111);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
