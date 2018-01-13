package glv_01_18.n6;

public class PC01 {
    public static void main(String[] args) {
        SingleElemBuff buff = new SingleElemBuff();
        new Thread(new Producer(1,1,333, buff)).start();
        new Thread(new Producer(2,100,555, buff)).start();
        new Thread(new Producer(3,1000,777, buff)).start();

        new Thread(new Consumer(1,buff)).start();
        new Thread(new Consumer(2,buff)).start();
    }
}
