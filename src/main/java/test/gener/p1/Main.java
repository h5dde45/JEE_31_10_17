package test.gener.p1;

public class Main {
    public static void main(String[] args) {
        G<String> stringG=new G<>();
        stringG.setT("qwe");
        String str = stringG.getT();
        System.out.println(str);

        G<Integer> integerG=new G<>();
        integerG.setT(345);
        Integer integer = integerG.getT();
        System.out.println(integer);
    }
}
class G<T>{
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
