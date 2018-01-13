package glv_01_18.n6;

public class SingleElemBuff {
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
        Integer result = this.elem;
        elem = null;
        this.notifyAll();
        return result;
    }
}
