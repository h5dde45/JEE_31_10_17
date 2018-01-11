package vlal.n11.p6;

public class Sequential {
    public static void main(String[] args) {
        int[] ints = Commons.prepareArrays();
        long startTime = System.currentTimeMillis();
        double sum = Commons.calculate(ints);
        double time = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.println("result = " + sum + ", during the " + time + " seconds");
    }
}
