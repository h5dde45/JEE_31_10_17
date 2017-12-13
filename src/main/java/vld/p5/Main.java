package vld.p5;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection<Person> collection=new ArrayList<>();
        collection.add(new Person("fName1","sName1"));

        System.out.println(collection.contains(new Person("fName1","sName1")));
    }
}
