package test.gener.p3;

public class Methods {
    public static void main(String[] args) {
        Class1<String> string = new Class1<>(23L);
        Integer integer = string.method2(45);
        System.out.println(integer);
    }

    private <T> T method(T t) {
        return t;
    }
}
class Class1<T>{
    T t;

    <X> Class1(X x){

    }

    public T method(T t) {
        return this.t=t;
    }

    public  <E> E method2(E e) {
        return e;
    }
}
