package bt_test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ints = {5, 2, 4, 6, 1, 3, 2, 6};
        System.out.println(Arrays.toString(ints));
        int[] sortInts = sort(ints);
        System.out.println(Arrays.toString(sortInts));
    }

    private static int[] sort(int[] ints) {
        if (ints.length < 2) return ints;

        int m = ints.length / 2;
        int[] left = new int[m];
        int[] right = new int[ints.length - m];

        for (int i = 0; i < m; i++) {
            left[i] = ints[i];
        }

        for (int i = m; i < ints.length; i++) {
            right[i - m] = ints[i];
        }

        return merge(sort(left), sort(right));
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length + arr2.length;
        int[] arr = new int[n];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < n; i++) {
            if (i1 == arr1.length) {
                arr[i] = arr2[i2++];
            } else if (i2 == arr2.length) {
                arr[i] = arr1[i1++];
            } else {
                if (arr1[i1] < arr2[i2]) {
                    arr[i] = arr1[i1++];
                } else {
                    arr[i] = arr2[i2++];
                }
            }
        }
        return arr;
    }
}
