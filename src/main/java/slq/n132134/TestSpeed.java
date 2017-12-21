package slq.n132134;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TestSpeed {
    private static final int COUNT = 1_000_000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> vector = new Vector<>();

        addingList(arrayList, "arrayList");
        addingList(linkedList, "linkedList");
        addingList(vector, "vector");
        System.out.println(arrayList.size() + " " + linkedList.size() + " " + vector.size());

        System.out.println("=========================");

        getByIndex(arrayList, "arrayList");
        getByIndex(linkedList, "linkedList");
        getByIndex(vector, "vector");
        System.out.println(arrayList.size() + " " + linkedList.size() + " " + vector.size());

        System.out.println("=========================");

        getByValue(arrayList, "arrayList");
        getByValue(linkedList, "linkedList");
        getByValue(vector, "vector");
        System.out.println(arrayList.size() + " " + linkedList.size() + " " + vector.size());

        System.out.println("=========================");

        addByIndex(arrayList, "arrayList");
        addByIndex(linkedList, "linkedList");
        addByIndex(vector, "vector");
        System.out.println(arrayList.size() + " " + linkedList.size() + " " + vector.size());

        System.out.println("=========================");

        delByIndex(arrayList, "arrayList");
        delByIndex(linkedList, "linkedList");
        delByIndex(vector, "vector");
        System.out.println(arrayList.size() + " " + linkedList.size() + " " + vector.size());

    }

    private static void delByIndex(List<Integer> list, String name) {
        long startTime = System.nanoTime();
        list.remove(COUNT/2);
        double resultTime = (double) (System.nanoTime() - startTime) / 1000_000_000;
        System.out.println(name + String.format("%8.6f", resultTime));
    }

    private static void addByIndex(List<Integer> list, String name) {
        long startTime = System.nanoTime();
        list.add(COUNT/2,111);
        double resultTime = (double) (System.nanoTime() - startTime) / 1000_000_000;
        System.out.println(name + String.format("%8.6f", resultTime));
    }

    private static void getByValue(List<Integer> list, String name) {
        long startTime = System.nanoTime();
        list.contains(COUNT/2);
        double resultTime = (double) (System.nanoTime() - startTime) / 1000_000_000;
        System.out.println(name + String.format("%8.6f", resultTime));
    }
    private static void getByIndex(List<Integer> list, String name) {
        long startTime = System.nanoTime();
        list.get(COUNT/2);
        double resultTime = (double) (System.nanoTime() - startTime) / 1000_000_000;
        System.out.println(name + String.format("%8.6f", resultTime));
    }

    private static void addingList(List<Integer> list, String name) {
        long startTime = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            list.add(i);
        }
        double resultTime = (double) (System.nanoTime() - startTime) / 1000_000_000;
        System.out.println(name + String.format("%8.5f", resultTime));
    }
}
