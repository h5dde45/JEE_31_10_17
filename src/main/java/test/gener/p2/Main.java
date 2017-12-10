package test.gener.p2;

public class Main {
    public static void main(String[] args) {

    }
}

class Parent {
}

class GenParent<T> extends Parent {
}

class Child extends GenParent {
}

class Child2 extends GenParent<String> {
}

class Child3<T> extends GenParent<T> {
}

class Child4<X, T> extends GenParent<T> {
}