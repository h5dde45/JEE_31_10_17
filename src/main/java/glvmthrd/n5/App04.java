package glvmthrd.n5;

public class App04 {
    public static void main(String[] args) {
        final Object monitor=new App04();

        new Thread(() -> {
            while (true){
                synchronized (monitor){
                    System.out.println("a");
                    System.out.println("====================");
                }
            }
        }).start();
        new Thread(() -> {
            while (true){
                synchronized (monitor){
                    System.out.println("b");
                    System.out.println("====================");
                }
            }
        }).start();
    }
}
