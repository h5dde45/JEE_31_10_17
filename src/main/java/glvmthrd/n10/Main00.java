package glvmthrd.n10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main00 {
    public static void main(String[] args) {
//        new Thread(() -> System.out.println("1111")).start();
//        new Thread(Main00::print).start();

        List<String> list = Arrays.asList("a", "bb", "ccc");

        Stream<String> stringStream = list.stream();
        Stream<Integer> integerStream = stringStream
                .map(String::length);
        Stream<Integer> integerStream1 = integerStream
                .filter(x -> x % 2 == 1);
        integerStream1
                .forEach(System.out::println);

//        List<String> list1 = Arrays.asList("a", "bb", "ccc");
//        for (String s:list1){
//            System.out.println(s);
//        }
//
//        for (int i = 0; i < list1.size(); i++) {
//            String s = list1.get(i);
//            System.out.println(s);
//        }
//        int i = 0;
//        while (i < list1.size()) {
//            String s = list1.get(i);
//            System.out.println(s);
//            i++;
//        }
//
//        for (Iterator<String> iterator = list1.iterator(); iterator.hasNext(); ) {
//            String s = iterator.next();
//            System.out.println(s);
//        }
//        Iterator<String> iterator = list1.iterator();
//        while (iterator.hasNext()) {
//            String s = iterator.next();
//            System.out.println(s);
//        }

        System.out.println("===============");
        Stream.iterate(0L, k -> k + 1)
                .filter(aLong -> aLong % 3 == 0)
                .map(aLong -> "~"+aLong)
                .limit(10)
                .forEach(System.out::println);

    }

    public static void print() {
        System.out.println("--==");
    }
}
