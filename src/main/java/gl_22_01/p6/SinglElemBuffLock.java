package gl_22_01.p6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SinglElemBuffLock {
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
            this.elem = newElem;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public void get() throws InterruptedException {
        lock.lock();
        try {
            while (elem == null) {
                notEmpty.await();
            }
            Integer result = elem;
            elem = null;
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }

}
