package tagval.u4;

public class Main {
    public static void main(String[] args) {
        Shmoption<String> present = new Shmoption<>("yes");
        Shmoption<String> absent = new Shmoption<>(null);

        System.out.println(present.isPresent());
        System.out.println(present.get());
        System.out.println(absent.isPresent());
        System.out.println(absent.orElse("no"));

        Shmoption<?> presentQ = new Shmoption<>("yes");
        System.out.println(presentQ.isPresent());
        Object o = presentQ.get();
        System.out.println(o);
        presentQ.set(null);

        Shmoption<? extends Number> number=new Shmoption<>(223);
        Number n = number.get();
        number.set(null);

        NumberShmoption<?> num=new NumberShmoption<>(456);
        Number number1 = number.get();
        num.set(null);

        IntegerShmoption numI=new IntegerShmoption(5456);
        Integer integer = numI.get();
        numI.set(958);

        num=numI;
    }
}
