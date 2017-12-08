package test.newthread.p2;

public class Main {
    public static void main(String[] args)  {
        Thread thread=new NewThread();
        thread.start();
        thread.setPriority(Thread.MAX_PRIORITY);
        try {
            Thread.sleep(13);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main");
    }
}
class NewThread extends Thread{
    @Override
    public void run() {
        System.out.println("thread-0");
    }
}
