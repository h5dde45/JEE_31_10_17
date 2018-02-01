package chat.noimpl;

public class Class24 {
    public static void main (String ... args) {

        A a = new B();

        a.foo();

//        a.hey();

    }
}
 class A {

    public void foo() {

        System.out.println("I’m A");

    }

}



class B extends A {

    public void foo() {

        System.out.println("I’m B");

    }



    public void hey(){

        System.out.println("Hey!");

    }

}
