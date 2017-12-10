package test.gener.p4;

public class Main {
    public static void main(String[] args) {
        Cl_1<Cl_2> cl_1 = new Cl_1<>();
        cl_1.setT(new Cl_2());
        cl_1.doJob();

        Cl_1<Child> cl_1C = new Cl_1<>();
        cl_1.setT(new Child());
        cl_1.doJob();

    }
}

class Cl_2 {
    void doIt() {
        System.out.println("doIt");
    }
}
class Child extends Cl_2{

}

class Cl_1<T extends Cl_2> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void doJob() {
        t.doIt();
    }

}