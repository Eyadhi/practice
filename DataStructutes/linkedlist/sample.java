package linkedlist;

public class sample {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	public void insert(int data) {
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;
		System.out.println(head.data);
	}

	public void delete() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Deleted:" + head.data);
		head = head.next;
	}

	public void display() {
		Node node = head;
		while (node != null) {
			System.out.println(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
}

class Linklist {
	public static void main(String[] args) {
		sample l1 = new sample();
		l1.insert(5);
		l1.insert(3);
		l1.insert(4);
		l1.display();

		sample l2 = new sample();
		l2.insert(1);
		l2.insert(2);
		l2.insert(6);
		l2.display();

	}

}
