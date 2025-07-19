package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		next = null;
	}
}

class Graph1 {
	private int v;
	private Node[] graph;

	public Graph1(int vertices) {
		v = vertices;
		graph = new Node[v];
		for (int i = 0; i < v; i++) {
			graph[i] = null;
		}
	}

	public void addEdge(int source, int destination) {
		Node node = new Node(destination);
		node.next = graph[source];
		graph[source] = node;
	}

	public void addVertex(int vk, int source, int destination) {
		addEdge(source, vk);
		addEdge(vk, destination);
	}

	public void display() {
		for (int i = 0; i < v; i++) {
			System.out.print(i + " ");
			Node temp = graph[i];
			while (temp != null) {
				System.out.print("->" + temp.data);
				temp = temp.next;
			}
			System.out.println();
		}
	}

	public void deleteVertex(int k) {
		for (int i = 0; i < v; i++) {
			Node temp = graph[i];
			if (i == k) {
				graph[i] = temp.next;
				temp = graph[i];
			}
			while (temp != null) {
				if (temp.data == k) {
					break;
				}
				Node prev = temp;
				temp = temp.next;
				if (temp == null) {
					continue;
				}
				prev.next = temp.next;
				temp = null;
			}
		}
	}
}

public class AdjacentListRep {

	public static void main(String[] args) {
		int V = 6;
		List<List<Integer>> adj = new ArrayList<>(V);
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 1, 2);
		addEdge(adj, 2, 3);
		System.out.println("Adjacent List Representation");
		display(adj);

		Graph1 obj = new Graph1(V);
		obj.addEdge(0, 1);
		obj.addEdge(0, 3);
		obj.addEdge(0, 4);
		obj.addEdge(1, 2);
		obj.addEdge(3, 2);
		obj.addEdge(4, 3);
		obj.display();

		obj.addVertex(5, 3, 2);
		obj.display();

		obj.deleteVertex(4);
		obj.display();
	}

	private static void display(List<List<Integer>> adj) {
		for (int i = 0; i < adj.size(); i++) {
			System.out.print(i + ":");
			for (int j : adj.get(i)) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

	}

	private static void addEdge(List<List<Integer>> adj, int i, int j) {
		adj.get(i).add(j);
		adj.get(j).add(i);

	}

}
