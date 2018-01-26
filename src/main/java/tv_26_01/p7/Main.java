package tv_26_01.p7;

import java.util.function.IntSupplier;

public class Main {
    public static void main(String[] args) {
        Runnable runnable=() -> System.out.println("++++");
        runnable.run();

        run(() -> System.out.println("========="));

        Object obj=(Runnable)()-> System.out.println("-----");
        ((Runnable)obj).run();

       Runnable runnable1= args.length>0?()-> System.out.println(">"):
               () -> System.out.println("<");
       runnable1.run();

        IntSupplier intSupplier= () -> 3;
        System.out.println(intSupplier.getAsInt());
        System.out.println((new IntSupplier() {
            @Override
            public int getAsInt() {
                return 5;
            }
        }).getAsInt());

    }
    private static void run(Runnable runnable){
        runnable.run();
    }
}
