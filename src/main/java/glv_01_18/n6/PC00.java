package glv_01_18.n6;

public class PC00 {
    public static void main(String[] args) {
        SingleElemBuff buff=new SingleElemBuff();
        new Thread(new Producer(1,1,1000,buff)).start();
    }
}
