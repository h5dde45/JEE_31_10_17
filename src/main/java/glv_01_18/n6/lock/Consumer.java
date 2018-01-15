package glv_01_18.n6.lock;

public class Consumer implements Runnable {
    private final int id;
    private final SingleElemBuffLoc buff;

    public Consumer(int id, SingleElemBuffLoc buff) {
        this.id = id;
        this.buff = buff;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int elem = buff.get();
                System.out.println("   " + System.currentTimeMillis() + ": " + elem +
                        " consumer by #" + id);
            } catch (InterruptedException ignore) {
            }
        }
    }
}
