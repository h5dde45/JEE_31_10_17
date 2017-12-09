package test.newthread.p9;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        ThreadB threadB = new ThreadB();
        threadB.start();
        synchronized (threadB){
            threadB.wait();
        }
        System.out.println(threadB.total);
    }
    static class ThreadB extends Thread{
        int total;
        @Override
        public void run() {
            synchronized (this){
                for (int i = 1; i <= 5; i++) {
                    total+=i;
                    try {
                        sleep(500);
                        System.out.println(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notify();
            }

        }
    }
}
