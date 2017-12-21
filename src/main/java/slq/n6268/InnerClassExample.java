package slq.n6268;

public class InnerClassExample {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
        System.out.println("------------------");
        Outer.Inner inner = new Outer().new Inner();
        inner.print();
        System.out.println("------------------");

        outer.test2();

    }
}

class Outer {
    int outer_var = 100;

    void test() {
        Inner inner = new Inner();
        inner.print();
    }

    class Inner {
        void print() {
            System.out.println(" class inner method printInner - " + outer_var);
        }
    }

    void test2() {
        class Inner2 {
            void print2() {
                System.out.println(" class inner2 method printInner2 - " + outer_var);
            }
        }
        Inner2 inner2 = new Inner2();
        for (int i = 0; i < 3; i++) {
            inner2.print2();
        }
    }

}
