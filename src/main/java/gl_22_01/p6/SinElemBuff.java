package gl_22_01.p6;

public class SinElemBuff {
    private Integer elem = null;

    public synchronized void put(int newElem) throws InterruptedException {
        while (elem != null) {
            this.wait();
        }
        elem = newElem;
        this.notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (elem == null) {
            this.wait();
        }
        Integer result = elem;
        elem = null;
        notifyAll();
        return result;
    }
}
