package vl_20_01.fork;

public class Comms {
    public static int[] prepareArray(){
        int[] array = new int[20_000_000];

        for (int i = 0; i < array.length; i++) {
            array[i]=i;
        }
        return array;
    }

    public static double calc(int[] array ){
        return calc(array,0,array.length);
    }

    public static double calc(int[] array, int start, int end) {
        double sum = 0.0;
        for (int i = start; i < end; i++) {
            sum+=func(array[i]);
        }
        return sum;
    }

    public static double func(int i) {
        return Math.sin(i);
    }


}
