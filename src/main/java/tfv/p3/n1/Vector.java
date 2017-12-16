package tfv.p3.n1;

public interface Vector {

    static Vector of(double x, double y, double z) {
        if (x == 0 && y == 0 && z == 0){
            return ZeroVector.INSTANCE;
        }
        return new ArrayVector(x, y, z);
    }

    double component(int n);

    default double length() {
        double x = component(0);
        double y = component(1);
        double z = component(2);
        return Math.sqrt(x * x + y * y + z * z);
    }

    Vector plus(Vector other);


}
