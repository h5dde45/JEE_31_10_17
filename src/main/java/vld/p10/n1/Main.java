package vld.p10.n1;

public class Main {
    public static void main(String[] args) {
//        Thread thread_0 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("++++");
//            }
//        });
//        Thread thread_0 = new Thread(() -> System.out.println("++++"));
//        thread_0.start();
        Num2 num2=new Num2();
        for (int i = 0; i < 10; i++) {
            new Thread(num2).start();//run();
        }
        Thread thread_2=new Thread(new Num2());
        thread_2.start();
//        thread_2.interrupt();

//        System.out.println(thread_0.getName());
//        System.out.println(thread_0.getId());
//        System.out.println(thread_0.isDaemon());
//        System.out.println(Arrays.toString(thread_0.getStackTrace()));
//        System.out.println(thread_0.getThreadGroup());
//        System.out.println(thread_0);
        System.out.println(Thread.currentThread().getName());
    }
}

class Num1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread: " + getName());
    }
}

class Num2 implements Runnable {
    @Override
    public void run() {
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Runnable: "+ Thread.currentThread().getName());
    }
}
