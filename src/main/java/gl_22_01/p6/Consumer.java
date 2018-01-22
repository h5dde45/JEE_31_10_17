package gl_22_01.p6;

public class Consumer implements Runnable {
    private final int id;
    private final SinElemBuff buff;

    public Consumer(int id, SinElemBuff buff) {
        this.id = id;
        this.buff = buff;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer elem = buff.get();
                System.out.println("   " + System.currentTimeMillis()
                        + " : value = " + elem + ", consumer by #" + id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
