package glvmthrd.n6;

public class Example_1 {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();

        new Thread(new Producer(1, 1, 300, buffer)).start();
//        new Thread(new Producer(2, 100, 500, buffer)).start();
//        new Thread(new Producer(3, 1000, 700, buffer)).start();
//
//        new Thread(new Consumer(2222, buffer)).start();
    }
}
