package glv_01_18.n6.lock;

public class Main {
    public static void main(String[] args) {

        SingleElemBuffLoc buff = new SingleElemBuffLoc();
        new Thread(new Producer(1, 1, 1000, buff)).start();
//        new Thread(new Producer(2, 1, 1000, buff)).start();
//        new Thread(new Producer(3, 1, 1000, buff)).start();

        new Thread(new Consumer(1,buff)).start();
//        new Thread(new Consumer(2,buff)).start();
    }
}
