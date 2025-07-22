package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    int v;
    List<List<Integer>> adjList;

    // Constructor
    BreadthFirstSearch(int noOfVertices) {
        v = noOfVertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add an edge to the graph
    void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    // Perform BFS traversal from the source vertex
    void breadthFirstSearch(int sourceVertex) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        visited[sourceVertex] = true;
        queue.offer(sourceVertex);

        System.out.print("BFS Traversal starting from vertex " + sourceVertex + ": ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    // Main method to test the BFS
    public static void main(String[] args) {
        BreadthFirstSearch graph = new BreadthFirstSearch(6);

        // Undirected graph - add edges both ways
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 2);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(5, 0);
        graph.addEdge(5, 4);

        // Start BFS from vertex 0
        graph.breadthFirstSearch(0);
    }
}
