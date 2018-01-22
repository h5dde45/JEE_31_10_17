package gl_22_01.p6;

public class P1C0 {
    public static void main(String[] args) {
        SinElemBuff buff = new SinElemBuff();
        new Thread(new Producer(1,1,333,buff)).start();
    }
}
