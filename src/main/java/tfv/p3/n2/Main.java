package tfv.p3.n2;

public class Main {
    public static void main(String[] args) {
//        Shmoption<String> present=new Shmoption<>("yes");
//        Shmoption<String> absent=new Shmoption<>(null);
//        System.out.println(present.isPresent());
//        System.out.println(present.get());
//        System.out.println(absent.isPresent());
//        System.out.println(absent.orElse("no"));
//        absent.set("weds");
//        System.out.println(absent.get());
//        System.out.println(absent.isPresent());
//        Shmoption<?> present=new Shmoption<>("yes");
//        System.out.println(present.isPresent());
//        System.out.println(present.get().getClass());
//        present.set(null);
//        Shmoption<? extends Number> number=new Shmoption<>(123);
//        Number number1=number.get();
//        number.set(null);

        NumberShmoption<?> number=new NumberShmoption<>(123);
        Number n=number.get();
        number.set(null);

        IntegerShmoption integer=new IntegerShmoption(345);
        Integer i = (Integer) integer.get();
        integer.set(222);

        number=integer;

    }
    static class NumberShmoption<N extends Number> extends Shmoption<N>{
        public NumberShmoption(N value) {
            super(value);
        }
    }
    static class IntegerShmoption extends NumberShmoption{
        public IntegerShmoption(Integer value) {
            super(value);
        }
    }
}
