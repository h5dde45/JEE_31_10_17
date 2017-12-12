package vld.p11.p6;

public class Sequential {
    public static void main(String[] args) {
        int[] array = Commons.prepareArray();
        long start = System.currentTimeMillis();

        double sum = Commons.calculate(array);
        long time = System.currentTimeMillis()-start;
        System.out.println(sum);
        System.out.println(time);

    }
}
