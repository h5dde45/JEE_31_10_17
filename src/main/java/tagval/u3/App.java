package tagval.u3;

public class App {
    public static void main(String[] args) {
//        Vector v1 = ZeroVector.INSTANCE;
//        Vector v2 = new ArrayVector(1, 2, 3);
//        Vector v3 = new FieldVector(4, 5, 6);
//
//        Vector sum = v1.plus(v2).plus(v3);
//        System.out.println(sum.component(0) + ", "
//                + sum.component(1) + ", "
//                + sum.component(2) + ", ");
//        System.out.println(sum);

        Vector v1 = ZeroVector.INSTANCE;
        Vector v2 = new ArrayVector(0, 0, 0);
        Vector v3 = new FieldVector(0, 0, 0);
        System.out.println(v2.equals(v1));
        System.out.println(v2.equals(v3));
        System.out.println(v1.equals(v2));
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
    }

    static class ArrayVector extends AbstractVector {
        double[] arr;

        public ArrayVector(double x, double y, double z) {
            this.arr = new double[]{x, y, z};
        }

        @Override
        public double component(int i) {
            return arr[i];
        }

        @Override
        public double length() {
            return Math.sqrt(arr[0] * arr[0] + arr[1] * arr[1] + arr[2] * arr[2]);
        }

        @Override
        public Vector plus(Vector other) {
            return new ArrayVector(
                    arr[0] + other.component(0),
                    arr[1] + other.component(1),
                    arr[2] + other.component(2));
        }
    }

    static class FieldVector extends AbstractVector {
        double x, y, z;

        public FieldVector(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public double component(int n) {
            switch (n) {
                case 0:
                    return this.x;
                case 1:
                    return this.y;
                case 2:
                    return this.z;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override
        public double length() {
            return Math.sqrt(x * x + y * y + z * z);
        }

        @Override
        public Vector plus(Vector other) {
            return new FieldVector(
                    x + other.component(0),
                    y + other.component(1),
                    z + other.component(2));
        }
    }

    static class ZeroVector extends AbstractVector {
        public static final ZeroVector INSTANCE = new ZeroVector();

        private ZeroVector() {
        }

        @Override
        public double component(int i) {
            return 0;
        }

        @Override
        public double length() {
            return 0;
        }

        @Override
        public Vector plus(Vector other) {
            return other;
        }
    }
}
