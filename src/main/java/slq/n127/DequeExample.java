package slq.n127;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("1");
        deque.add("2");
        System.out.println(deque.add("3"));
        System.out.println(deque.offer("4"));
        System.out.println(deque);
        System.out.println(deque.element());
        System.out.println(deque);
        System.out.println(deque.remove());
        System.out.println(deque);
        deque.addLast("33");
        deque.addFirst("133");
        deque.push("3133");
        deque.pop();
        System.out.println(deque);
    }
}
