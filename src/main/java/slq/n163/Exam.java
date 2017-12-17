package slq.n163;

public class Exam {
    public static void main(String[] args) {
        Ex<Double> md1=new Ex<>(75.95,"Math");
        Ex<Double> md2=new Ex<>(75.75,"Math");
//        System.out.println(md1.roundMark());

        System.out.println(md1.equalsToMark(md2));
        Ex<Integer> mi=new Ex<>(76,"Math");
        System.out.println(mi.equalsToMark(md2));

    }
}

class Ex<T extends Number> {
    private String name;
    private T mark;

    public Ex( T mark, String name) {
        this.name = name;
        this.mark = mark;
    }

    public T getMark() {
        return mark;
    }

    private int roundMark() {
        return Math.round(mark.floatValue());
    }

//    public boolean equalsToMark(Ex<T> obj) {
//        return roundMark() == obj.roundMark();
//    }
    public boolean equalsToMark(Ex<? extends Number> obj) {
        return roundMark() == obj.roundMark();
    }
}