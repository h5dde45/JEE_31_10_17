package slq.n4044;

public class Child extends Parent {
    @Override
    void test() {
        System.out.println("child...");
    }

    void testSup() {
        super.test();
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.test();

        Parent parent = new Parent();
        parent.test();

        parent = child;
        parent.test();

        child.testSup();
    }
}

class Parent {
    void test() {
        System.out.println("parent....");
    }
}
