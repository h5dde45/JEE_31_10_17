package glvmthrd.n7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingleElementBuffer {
    private final Lock lock = new ReentrantLock();
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
        } finally {
            lock.unlock();
        }
    }

}
