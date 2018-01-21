package vl_20_01.fork;

public class Sequential {
    public static void main(String[] args) {
        int[] array = Comms.prepareArray();
        long start = System.currentTimeMillis();
        double sum = Comms.calc(array);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " = " + sum);
    }
}
