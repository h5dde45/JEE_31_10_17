package tagval.u7;

import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class App {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("====================");
        runnable.run();

        run(() -> System.out.println("+++++++"));
        Object o = (Runnable) (() -> System.out.println("+++++++"));

        Runnable runnable1 = args.length > 0 ?
                () -> System.out.println("1111") :
                () -> System.out.println("2222");
        runnable1.run();
        System.out.println("-------------------------");
        IntSupplier intSupplier=() -> 3;
        System.out.println(intSupplier.getAsInt());
        System.out.println(((DoubleSupplier) ()->33).getAsDouble());

//        IntSupplier intSupplier1= () -> {
//            while (true) {
//            }
//        };
//        System.out.println(intSupplier1.getAsInt());

        System.out.println("-------------------------");

        Consumer<Object> lambdaPrint= (x) -> System.out.println(x);
        Consumer<Object> refPrint= System.out::println;

//        System.setOut(null);
        lambdaPrint.accept("555");
        refPrint.accept("666");
    }

    private static void run(Runnable runnable) {
        runnable.run();
    }
}
