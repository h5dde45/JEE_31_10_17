package glvmthrd.n6;

public class Producer implements Runnable {
    private final int id;
    private int value;
    private final int period;
    private final SingleElementBuffer buffer;

    public Producer(int id, int value, int period, SingleElementBuffer buffer) {
        this.id = id;
        this.value = value;
        this.period = period;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(System.currentTimeMillis() + ": " +
                        value + " producer #" + id);
                buffer.put(value++);
                Thread.sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
