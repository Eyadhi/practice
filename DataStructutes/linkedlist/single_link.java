package linkedlist;

import java.util.*;

public class single_link {
	static Node head;

	class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	public Node insertBeg(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		return head;
	}

	public void insertEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.next != null)
			temp = temp.next;
		temp.next = newNode;
	}

	public void insertAfter(int n, int data) {
		int size = calcSize(head);
		if (n < 1 || n > size) {
			System.out.println("can't insert\n");
		} else {
			Node newNode = new Node(data);
			Node temp = head;
			while (--n > 1)
				temp = temp.next;
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}

	public boolean search(int x) {
		Node current = head;
		while (current != null) {
			if (current.data == x)
				return true;
			current = current.next;
		}
		return false;
	}

	public void display() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public int calcSize(Node node) {
		int size = 0;
		while (node != null) {
			node = node.next;
			size++;
		}
		return size;
	}

	public void deleteStart() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Deleted item:" + head.data);
		head = head.next;
	}

	public void deletepos(int n) {
		int size = calcSize(head);
		if (n < 1 || n > size) {
			System.out.println("Enter valid position");
			return;
		}
		if (n == 1) {
			System.out.println("Deleted item:" + head.data);
			head = head.next;
			return;
		}
		Node temp = head;
		Node previous = null;
		while (--n > 0) {
			previous = temp;
			temp = temp.next;
		}
		previous.next = temp.next;

		System.out.println("Deleted Item:" + temp.data);
	}

	public void deletelast() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		if (head.next == null) {
			System.out.println("Deleted item:" + head.data);
			head = head.next;
			return;
		}
		Node previous = null;
		Node temp = head;
		while (temp.next != null) {
			previous = temp;
			temp = temp.next;
		}
		System.out.println("Deleted Item:" + temp.data);
		previous.next = null;
	}

	public int MiddleNode() {
		return MiddleNode(head);
	}

	public int MiddleNode(Node head) {
		if (head == null) {
			return 0;
		}
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}

	public Node insertInMiddle(Node head, int x) {
		if (head == null) {
			return new Node(x);
		}
		Node newNode = new Node(x);
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		Node tempptr = slow.next;
		slow.next = newNode;
		newNode.next = tempptr;
		return head;
	}

	public Node deleteMid(Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		Node prev = null;
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		prev.next = slow.next;
		return head;
	}

	public Node reverse(Node head) {
		Node prev = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	public Node reverse_using_rec(Node head) {
		if (head == null || head.next == null)
			return head;
		Node rest = reverse_using_rec(head.next);
		head.next.next = head;
		head.next = null;
		return rest;
	}

	public void reverse_using_stack() {
		Stack<Node> s = new Stack<>();
		Node temp = head;
		while (temp.next != null) {
			s.add(temp);
			temp = temp.next;
		}
		head = temp;
		while (!s.isEmpty()) {
			temp.next = s.peek();
			s.pop();
			temp = temp.next;
		}
		temp.next = null;
	}

	public void remDuplicates() {
		Node current = head;
		while (current != null && current.next != null) {
			if (current.data == current.next.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
	}

	public void remDuplicates1() {
		Set<Integer> s = new HashSet<>();
		Node temp = head;
		Node prev = null;
		while (temp != null) {
			int curval = temp.data;
			if (s.contains(curval)) {
				prev.next = temp.next;
			} else {
				s.add(curval);
				prev = temp;
			}
			temp = temp.next;
		}
	}

	public int EndNode(int n) {
		Node mainptr = head;
		Node refptr = head;
		int count = 0;
		while (count < n) {
			refptr = refptr.next;
			count++;
		}
		while (refptr != null) {
			refptr = refptr.next;
			mainptr = mainptr.next;
		}
		return mainptr.data;
	}

	public Node rotateRight(Node head, int k) {
		if (head == null)
			return head;

		Node node = head;
		int size = 1;
		while (node.next != null) {
			node = node.next;
			size++;
		}

		k = k % size;
		if (k == 0)
			return head;

		Node curr = head;
		for (int i = 0; i < size - k - 1; i++) {
			curr = curr.next;
		}

		Node newHead = curr.next;
		curr.next = null;
		node.next = head;

		return newHead;
	}

	public Node removeNthFromEnd(Node head, int n) {
		Node slow = head;
		int count = 1;
		while (slow.next != null) {
			slow = slow.next;
			count++;
		}
		slow = head;
		if (n == count) {
			return head.next;
		}
		int steps = count - n - 1;
		while (steps-- > 0) {
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}

	public void Sort() {
		Node temp = head;
		int d;
		while (temp != null && temp.next != null) {
			if (temp.data < temp.next.data) {
				temp = temp.next;
			} else {
				d = temp.data;
				temp.data = temp.next.data;
				temp.next.data = d;
			}
		}
	}

	public void BubbleSort() {
		boolean swaped;
		if (head == null) {
			return;
		}
		do {
			Node temp = head;
			swaped = false;
			while (temp.next != null) {
				if (temp.data > temp.next.data) {
					swap(temp, temp.next);
					swaped = true;
				}
				temp = temp.next;
			}
		} while (swaped);
	}

	public void swap(Node x, Node y) {
		int temp = x.data;
		x.data = y.data;
		y.data = temp;
	}

	static Node sortedMerge(Node a, Node b) {
		Node result = null;
		if (a == null)
			return b;
		if (b == null)
			return a;
		// Pick either a or b, and recur
		if (a.data <= b.data) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;
	}

	static void mergeSort(Node headRef) {
		Node head = headRef;
		Node a, b;
		// Base case -- length 0 or 1
		if (head == null || head.next == null) {
			return;
		}
		// Split head into 'a' and 'b' sublists
		Node[] frontRef = new Node[1];
		Node[] backRef = new Node[1];
		frontBackSplit(head, frontRef, backRef);
		a = frontRef[0];
		b = backRef[0];
		// Recursively sort the sublists
		mergeSort(a);
		mergeSort(b);
		// Answer = merge the two sorted lists together
		headRef = sortedMerge(a, b);
	}

	static void frontBackSplit(Node source, Node[] frontRef, Node[] backRef) {
		Node slow = source;
		Node fast = source.next;
		// Advance 'fast' two nodes, and advance 'slow' one node
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		// 'slow' is before the midpoint in the list, so split it in two at that point
		frontRef[0] = source;
		backRef[0] = slow.next;
		slow.next = null;
	}

	public void SortAdd(int d) {
		Node newNode = new Node(d);
		if (head.data > d) {
			newNode.next = head;
			head = newNode;
		}
		Node current = head.next;
		Node temp = head;
		while (current != null && current.data < d) {
			temp = temp.next;
			current = current.next;
		}
		temp.next = newNode;
		newNode.next = current;
	}

	public boolean ContainsLoop() {
		Node slowptr = head;
		Node fastptr = head;
		while (fastptr != null && fastptr.next != null) {
			slowptr = slowptr.next;
			fastptr = fastptr.next.next;
			if (slowptr == fastptr) {
				return true;
			}
		}
		return false;
	}

	public int countNodesinLoop(Node head) {
		// Add your code here.
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		if (fast == null || fast.next == null)
			return 0;
		slow = slow.next;
		int count = 1;
		while (slow != fast) {
			count++;
			slow = slow.next;
		}
		return count;
	}

	public int startLoop() {
		Node slowptr = head;
		Node fastptr = head;
		while (fastptr != null && fastptr.next != null) {
			slowptr = slowptr.next;
			fastptr = fastptr.next.next;
			if (slowptr == fastptr) {
				return Startingpoint(slowptr);
			}
		}
		return 0;
	}

	public int Startingpoint(Node slowptr) {
		Node temp = head;
		while (slowptr != temp) {
			temp = temp.next;
			slowptr = slowptr.next;
		}
		return temp.data;
	}

	public void CreateLoop() {
		Node first = new Node(1);
		Node second = new Node(2);
		Node Third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);
		head = first;
		first.next = second;
		second.next = Third;
		Third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = fourth;
	}

	public void remove() {
		Node slowptr = head;
		Node fastptr = head;
		while (fastptr != null && fastptr.next != null) {
			slowptr = slowptr.next;
			fastptr = fastptr.next.next;
			if (slowptr == fastptr) {
				removeLoop(slowptr);
			}
		}
	}

	public void removeLoop(Node slowptr) {
		Node temp = head;
		while (slowptr != temp) {
			temp = temp.next;
			slowptr = slowptr.next;
		}
		slowptr.next = null;
	}

	public void evenOddLinkedList(Node head) {
		if (head == null || head.next == null) {
			return;
		}
		Node odd = head;
		Node even = head.next;
		Node evenfirst = even;
		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = evenfirst;
	}

	public void swapLinkedList(Node head) {
		Node current = head;
		Node previous = head.next;
		while (current != null && current.next != null) {
			current.next = current.next.next;
			previous.next = current;
			previous = current;
			current = current.next;
		}
	}

	public void rotateLinkedList(Node head, int k) {
		if (k == 0)
			return;
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = head;
		Node current1 = head;
		for (int i = 0; i < k - 1; i++) {
			current1 = current1.next;
		}
		head = current1.next;
		current1.next = null;
	}

	public Node merge(Node a, Node b) {
		Node dummy = new Node(0);
		Node tail = dummy;
		while (a != null && b != null) {
			if (a.data <= b.data) {
				tail.next = a;
				a = a.next;
			} else {
				tail.next = b;
				b = b.next;
			}
			tail = tail.next;
		}
		if (a == null) {
			tail.next = b;
		} else {
			tail.next = a;
		}
		return dummy.next;
	}

	boolean isPalindrome(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = reverse(slow);
		fast = head;
		while (slow != null) {
			if (slow.data != fast.data) {
				return false;
			}
			slow = slow.next;
			fast = fast.next;
		}
		return true;
	}

	public static void main(String[] args) {
		single_link obj = new single_link();
		obj.insertBeg(15);
		obj.insertBeg(20);
		obj.insertBeg(5);
		obj.display();

		/*
		 * obj.insertEnd(20);
		 * obj.insertEnd(50);
		 * obj.insertEnd(20);
		 * obj.insertEnd(10);
		 * obj.display();
		 * 
		 * /*obj.insertAfter(3, 40);
		 * obj.display();
		 * 
		 * obj.deleteStart();
		 * obj.display();
		 * 
		 * obj.deletepos(3);
		 * obj.display();
		 * 
		 * obj.deletelast();
		 * obj.display();
		 * System.out.println(obj.search(20));
		 * 
		 * head=obj.reverse(head);
		 * obj.display();
		 * 
		 * head=obj.reverse_using_rec(head);
		 * obj.display();
		 * 
		 * obj.reverse_using_stack();
		 * obj.display();
		 * 
		 * int middle=obj.MiddleNode(head);
		 * System.out.println("middle node is"+middle);
		 * 
		 * obj.remDuplicates();
		 * obj.display();
		 * obj.insertEnd(3);
		 * obj.insertEnd(2);
		 * obj.insertEnd(1);
		 * 
		 * /*
		 * obj.SortAdd(17);
		 * obj.display();
		 * 
		 * obj.CreateLoop();
		 * System.out.println(obj.ContainsLoop());
		 * obj.remove();
		 * System.out.println(obj.ContainsLoop());
		 * System.out.println(obj.startLoop());
		 * 
		 * obj.insertEnd(1);
		 * obj.insertEnd(2);
		 * obj.insertEnd(3);
		 * obj.insertEnd(3);
		 * obj.insertEnd(4);
		 * obj.insertEnd(4);
		 * obj.insertEnd(5);
		 * obj.display();
		 * int val=obj.EndNode(3);
		 * System.out.println("End node is"+val);
		 * obj.remDuplicates1();
		 * obj.display();
		 * obj.remDuplicates1();
		 * obj.display();
		 * obj.Sort();
		 * obj.display();
		 * obj.BubbleSort();
		 * obj.display();
		 * mergeSort(head);
		 * obj.display();
		 * obj.evenOddLinkedList(head);
		 * obj.display();
		 * obj.swapLinkedList(head);
		 * obj.display();
		 * obj.rotateLinkedList(head, 2);
		 * obj.display();
		 * obj.CreateLoop();
		 * //obj.display();
		 * System.out.println(obj.ContainsLoop());
		 * System.out.println(obj.countNodesinLoop(head));
		 */
		obj.SortAdd(6);
		obj.display();

	}
}
