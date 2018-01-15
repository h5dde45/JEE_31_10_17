package glv_01_18.n6.lock;

public class Producer implements Runnable {
    private final int id;
    private int value;
    private final int period;
    private final SingleElemBuffLoc buff;

    public Producer(int id, int value, int period, SingleElemBuffLoc buff) {
        this.id = id;
        this.value = value;
        this.period = period;
        this.buff = buff;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(""+System.currentTimeMillis() + ": " + value +
                        " producer by #" + id);
                buff.put(value++);
                Thread.sleep(period);
            } catch (InterruptedException ignore) {
            }
        }
    }
}
