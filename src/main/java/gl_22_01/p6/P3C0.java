package gl_22_01.p6;

public class P3C0 {
    public static void main(String[] args) {
        SinElemBuff buff = new SinElemBuff();
        new Thread(new Producer(1,1,1111,buff)).start();
        new Thread(new Producer(2,1,1111,buff)).start();
        new Thread(new Producer(3,1,1111,buff)).start();
    }
}
