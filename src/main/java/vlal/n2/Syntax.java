package vlal.n2;

public class Syntax {
    public static void main(String[] args) {
        short n = -1;
        System.out.println(Integer.toBinaryString(n));
        n >>= 1;
        System.out.println(Integer.toBinaryString(n));
        n >>>= 1;
        System.out.println(Integer.toBinaryString(n));
        n <<= 1;
        System.out.println(Integer.toBinaryString(n));


        n = Short.MAX_VALUE;
        System.out.println(Integer.toBinaryString(n));
        n = Short.MIN_VALUE;
        System.out.println(Integer.toBinaryString(n));
        n = 0;
        System.out.println(Integer.toBinaryString(n));
        n = -1;
        System.out.println(Integer.toBinaryString(n));
        System.out.println("=====================");
        int i = -1;
        System.out.println(Integer.toBinaryString(i));
        i >>= 1;
        System.out.println(Integer.toBinaryString(i));
        i >>>= 1;
        System.out.println(Integer.toBinaryString(i));
        i <<= 1;
        System.out.println(Integer.toBinaryString(i));

        System.out.println("=====================");
        short sh = -1;
        System.out.println(Integer.toBinaryString(sh));
        for (int j = 0; j < 5; j++) {
            System.out.println(Integer.toBinaryString(sh >>> 1));
            sh >>>= 1;
            System.out.println(Integer.toBinaryString(sh));
        }

        int[] ints = {1, 2, 3, 4, 5, 6};
        for (int i1 : ints) {
            System.out.println(i1);
        }
    }
}
