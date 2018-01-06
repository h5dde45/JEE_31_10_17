package tagval.u10;

public class AppVolatile {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100_000; i++) {
            Foo foo = new Foo();
            Thread thread1 = new Thread(() -> {
                foo.x = 1;
                foo.y = 1;
            });
            Thread thread2 = new Thread(() -> {
                while (foo.y != 1) {
                }
                System.out.println(foo.x);
            });
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
        }
    }
}

class Foo {
    int x = 0;
    volatile int y = 0;
}
