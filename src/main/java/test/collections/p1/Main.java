package test.collections.p1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

        List<String> list=new ArrayList<>();
        Set<String> set=new HashSet<>();
        Queue<String> queue=new LinkedList<>();
        Map<String, String> map=new HashMap<>();

        collection.add("one");
        collection.add("two");
        System.out.println(collection.size());
        collection.remove("one");
        System.out.println(collection.size());
        collection.contains("two");
        collection.add("one");
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(collection.size());
        for (String s : collection) {
            System.out.println(s);
        }
//        ================================
        System.out.println("++++++++++++++++++++++++++");
        list.add("one");
        list.add("one");
        list.add("two");
        System.out.println(list.get(1));
//        ================================
        System.out.println("++++++++++++++++++++++++++");
        set.add("one");
        set.add("one");
        set.add("two");
        System.out.println(set.size());
//        System.out.println(set.);

        queue.add("one");
        queue.add("two");
        System.out.println(queue.offer("three"));
        System.out.println(queue.element());

        map.put("1","qwe");
        map.put("2","2qwe");
        map.remove("2","qwe");
        System.out.println(map.get("2"));

    }
}
