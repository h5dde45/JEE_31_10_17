package glvmthrd.n6;

public class SingleElementBuffer {
    private Integer elem;

    public synchronized void put(int newElement) throws InterruptedException {
        while (elem != null) {
            this.wait();
        }
        elem = newElement;
        this.notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (elem == null) {
            this.wait();
        }
        Integer result = elem;
        elem = null;
        this.notifyAll();
        return result;
    }
}
