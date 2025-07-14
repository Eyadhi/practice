package queue;

import java.util.*;

//Java program to implement Queue using two stacks with costly enQueue()
public class queue_using_stack {
	static Stack<Integer> s1 = new Stack<Integer>();
	static Stack<Integer> s2 = new Stack<Integer>();

	static void enQueue(int x) {
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s1.push(x);
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}

	static void deQueue() {
		if (s1.isEmpty()) {
			System.out.println(-1);
		}
		int x = s1.peek();
		s1.pop();
		System.out.println(x);
	}

	public static void main(String[] args) {
		enQueue(1);
		enQueue(2);
		enQueue(3);
		deQueue();
		deQueue();
		// deQueue();
	}
}