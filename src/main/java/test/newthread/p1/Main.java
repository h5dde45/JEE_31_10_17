package test.newthread.p1;

public class Main {
    public static void main(String[] args) {
        new Thread_0().start();
        new Thread_0().start();
        new Thread_0().start();
        new Thread_0().start();

    }
}

class Thread_0 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 400; i++) {
            System.out.println(">> " + Thread.currentThread().getName() + " = " + i);
        }
    }
}


