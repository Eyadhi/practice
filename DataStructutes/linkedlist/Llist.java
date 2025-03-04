package linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Llist {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> l1 = new LinkedList<>();
		l1.add(3);
		l1.add(4);
		l1.add(19);
		l1.add(2, 5);
		// l1.remove(2);
		// l1.removeFirst();
		Iterator it = l1.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println(l1.size());
		boolean b1 = l1.contains(5);
		System.out.println(b1);
		// copy elements from stack to linkedlist
		Stack<String> s1 = new Stack<>();
		LinkedList<String> l2 = new LinkedList<>();
		s1.push("hello");
		s1.push("world");
		l2.addAll(s1);
		Iterator it1 = l2.iterator();
		while (it1.hasNext()) {
			System.out.print(it1.next() + " ");
		}
	}
}
