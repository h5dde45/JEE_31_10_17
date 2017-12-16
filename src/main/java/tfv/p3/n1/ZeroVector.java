package tfv.p3.n1;

public class ZeroVector extends AbstractVector {
    static final ZeroVector INSTANCE = new ZeroVector();

    private ZeroVector() {
    }

    @Override
    public double component(int n) {
        return 0;
    }

//    @Override
//    public double length() {
//        return 0;
//    }

    @Override
    public Vector plus(Vector other) {
        return other;
    }

}
