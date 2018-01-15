package glv_01_18.n6.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingleElemBuffLoc {
    private final Lock lock = new ReentrantLock(true);
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();
    private Integer elem = null;

    public void put(int newElem) throws InterruptedException {
        lock.lock();
        try {
            while (elem != null) {
                notFull.await();
            }
            elem = newElem;
            notEmpty.signal();
            System.out.print("");
        } finally {
            lock.unlock();
        }
    }

    public synchronized int get() throws InterruptedException {
        lock.lock();
        try {
            while (elem == null) {
                notEmpty.await();
            }
            Integer result = this.elem;
            elem = null;
            notFull.signal();
            return result;
        }finally {
            lock.unlock();
        }
    }
}