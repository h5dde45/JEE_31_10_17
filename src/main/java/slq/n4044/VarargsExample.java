package slq.n4044;

public class VarargsExample {
    public static void main(String[] args) {
        fly();
        fly(1,2);
        fly("asd",0,1,2);
        fly(new  int[]{0,1,2,7,8});
    }
    static void fly(int...ints){
        System.out.println(ints.length);
    }
    static void fly(String s, int...ints){
        System.out.println(ints.length);
    }
}
