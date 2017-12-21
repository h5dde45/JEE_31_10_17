package glvmthrd.n5;

public class App {
    public static void main(String[] args) throws InterruptedException {
     new App().fff();
    }

    private synchronized  void fff() {
        System.out.println(Thread.holdsLock(this));
    }

    private /*synchronized*/ void f() {
        synchronized (this) {
            g();
        }
    }

    private static /*synchronized*/ void g() {
        Class newClass = App.class;
        synchronized (newClass) {
            h();
        }
    }

    private static void h() {
        System.out.println("+++++++++++++++");
    }
}
