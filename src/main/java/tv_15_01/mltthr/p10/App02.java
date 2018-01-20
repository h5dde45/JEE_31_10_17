package tv_15_01.mltthr.p10;

public class App02 {
    static int count=0;
    public static void main(String[] args) throws InterruptedException {
        class Foo {
            int x = 0;
            volatile int y = 0;
        }
        for (int i = 0; i < 1000; i++) {
            Foo foo = new Foo();
            Thread thread_1 = new Thread(() -> {
                foo.x = 1;
                foo.y = 1;
            });
            Thread thread_2 = new Thread(() -> {
                while (foo.y != 1) {
                }
                System.out.print(++count+" = ");
                System.out.println(foo.x);
            });
            thread_1.start();
            thread_2.start();
            thread_1.join();
            thread_2.join();
        }

    }
}
