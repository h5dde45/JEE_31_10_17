package chat;

import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
//        System.out.println(fib(3));
        System.out.println(IntStream.of(1, 2, 3).map(x -> x * x).sum());
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(a[1][2] + a [0][0]);
        int f = f(6);
        System.out.println(f);
        System.out.println(3 | 4);
    }
   static int fib(int n) {

        return fib(n - 1) + fib(n - 2);

    }
    static int f(int n) {

        if (n <= 0) {

            return 0;

        }

        return n + f(n / 2);

    }


}
