package slq.n127;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue=new PriorityQueue<>();
        queue.add("1");
        queue.add("2");
        System.out.println(queue.add("3"));
        System.out.println(queue.offer("4"));
        System.out.println(queue);
        System.out.println(queue.element());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
    }
}
