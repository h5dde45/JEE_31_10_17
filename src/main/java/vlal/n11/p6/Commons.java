package vlal.n11.p6;

public class Commons {
    public static int[] prepareArrays(){
        int[] array=new int[20_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i]=i;
        }
        return array;
    }
    public static double calculate(int[] array){
        return calculate(array,0,array.length);
    }

    public static double calculate(int[] array, int start, int end) {
        double sum=0;
        for (int i = start; i < end; i++) {
            sum+=function(array[i]);
        }
        return sum;
    }
    public static double function(int arg){
        return Math.sin(arg);
    }
}
