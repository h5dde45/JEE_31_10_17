package glvmthrd.n4;

public class App1 {
    private static Str str = null;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> str = new Str(new char[]{'a', 's', 'd'}, 0, 3)).start();

        while (true) {
            Str tmp = str;
            if (tmp != null) {
                System.out.println(str.getValue());
                System.out.println(str.getOff());
                System.out.println(str.getLen());
                break;
            }
//            System.out.println("qwert".substring(2));
        }
    }
}

class Str {
    private char[] value;
    private int off;
    private int len;

    public Str(char[] value, int off, int len) {
        this.value = value;
        this.off = off;
        this.len = len;
    }

    public char[] getValue() {
        return value;
    }

    public int getOff() {
        return off;
    }

    public int getLen() {
        return len;
    }
}