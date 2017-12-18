package slq.n336;

import java.util.Arrays;

public class SimpleEnum {
    public static void main(String[] args) {
        Dog dog = Dog.SECOND;
        System.out.println(dog);

        dog = Dog.FIFTH;
        System.out.println(dog);

        switch (dog){
            case FOURTH:
                System.out.println("fourth");
                break;
            case SECOND:
                System.out.println("fourth");
                break;
            default:
                System.out.println("=====");
        }
        Dog[] values = Dog.values();
        System.out.println(Arrays.toString(values));
        System.out.println(values.getClass());
        System.out.println(Dog.class);
        System.out.println(Dog.class.getName());
        System.out.println(Dog.valueOf("SECOND"));
        System.out.println(Dog.FOURTH.ordinal());

    }
}
