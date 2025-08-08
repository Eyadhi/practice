package graphs;

import java.util.LinkedList;

public class DepthFirstSearch {
   int V;
   LinkedList<Integer>[] adj;

   @SuppressWarnings("unchecked")
   DepthFirstSearch(int numVertices) {
      V = numVertices;
      adj = new LinkedList[V];
      for (int i = 0; i < V; i++) {
         adj[i] = new LinkedList<>();
      }
   }

   // Add edge from vertex x to y
   void addEdge(int x, int y) {
      adj[x].add(y);
   }

   // DFS starting from a given vertex
   void depthFirstSearch(int start) {
      boolean[] visited = new boolean[V];
      System.out.print("DFS starting from vertex " + start + ": ");
      dfsUtil(start, visited);
   }

   // Utility method for DFS
   void dfsUtil(int v, boolean[] visited) {
      visited[v] = true;
      System.out.print(v + " ");

      for (int neighbor : adj[v]) {
         if (!visited[neighbor]) {
            dfsUtil(neighbor, visited);
         }
      }
   }

   public static void main(String[] args) {
      DepthFirstSearch graph = new DepthFirstSearch(6);

      // Adding edges
      graph.addEdge(0, 1);
      graph.addEdge(0, 2);
      graph.addEdge(0, 5);
      graph.addEdge(1, 0);
      graph.addEdge(1, 2);
      graph.addEdge(2, 0);
      graph.addEdge(2, 1);
      graph.addEdge(2, 3);
      graph.addEdge(3, 3);
      graph.addEdge(4, 5); // Optional - not connected to others
      graph.addEdge(5, 4);

      // Start DFS from vertex 2
      graph.depthFirstSearch(2);
   }
}
