package queue;
// Queue Interface - PriorityQueue

import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(10);
        queue.offer(5);
        System.out.println(queue.peek()); // 5
        System.out.println(queue.poll()); // 5
        System.out.println(queue.remove()); // 10

        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("A");
        deque.addLast("B");
        System.out.println(deque.peekFirst()); // A
        System.out.println(deque.pollLast()); // B
    }
}
