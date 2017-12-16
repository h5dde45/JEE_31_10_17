package tfv.p3.n1;

public class Main {
    public static void main(String[] args) {
        Vector v1 = ZeroVector.INSTANCE;
        Vector v2 = new ArrayVector(1,2,3);
        Vector v3 = new FieldVector(4,5,6);
        Vector v4 = Vector.of(7, 8, 9);

        Vector sum = v1.plus(v2).plus(v4).plus(v3);
        System.out.println(sum.component(0) + ", " +
                sum.component(1) + ", " + sum.component(2));
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v1.length());
        System.out.println(v2.length());
        System.out.println(v3.length());
        System.out.println(v4.length());
        System.out.println(v2.equals(v1));
        System.out.println(v2.equals(v3));
        System.out.println(v1.equals(v2));
    }
}
