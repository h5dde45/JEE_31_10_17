package glv_01_18.n6;

public class Consumer implements Runnable {
    private final int id;
    private final SingleElemBuff buff;

    public Consumer(int id, SingleElemBuff buff) {
        this.id = id;
        this.buff = buff;
    }

    @Override
    public void run() {
        try {
            int elem = buff.get();
            System.out.println("   "+System.currentTimeMillis() + ": " + elem +
                    " consumer by #" + id);
        } catch (InterruptedException ignore) {
        }
    }
}
