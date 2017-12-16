package tfv.p7;

import java.util.function.IntSupplier;

public class Main {
    public static void main(String[] args) {
//        Runnable runnable = () -> System.out.println("++++");
//        runnable.run();
//
//        run(() -> System.out.println("===="));
//
//        ((Runnable) () -> System.out.println("654")).run();
//
//        Runnable length = args.length > 0 ?
//                () -> System.out.println(args[0]) :
//                () -> System.out.println("-------");
//        length.run();
        IntSupplier intSupplier=() -> 5;
        System.out.println(intSupplier.getAsInt());



    }

    static void run(Runnable runnable) {
        runnable.run();
    }
}
