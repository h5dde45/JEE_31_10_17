package chat.noimpl;

import java.util.ArrayList;
import java.util.List;

public class Class23 {
    public static void main(String[] args) {
        System.out.println(Class23.Node.height(new Node()));
    }
    static class Node {

        Node left;

        Node right;


        static int height(Node node) {

            if (node == null) {

                return 0;

            }


            int left = height(node.left);

            int right = height(node.right);

            return Math.max(left, right);

        }

    }
}
class Animal {}



class Dog extends Animal {

    public static void main(String[] args) {

        List<Dog> dogs = new ArrayList<>();

//        List<Animal> animals = dogs;

    }

}
