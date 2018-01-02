package tagval.u3;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(3, 4);
        Point.AnotherClass another = point.getAnother();
        another.print();
    }
}

class Point {
    private final int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    AnotherClass getAnother(){
        return new AnotherClass();
    }

    class AnotherClass {
        void print() {
            System.out.println("another: " + x + ", " + y);
        }
    }
}
