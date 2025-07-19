package graphs;

import java.util.LinkedList;
import java.util.ListIterator;

public class DepthFirstSearch {
   int V;
   LinkedList<Integer>[] adj;

   DepthFirstSearch(int nov) {
      V = nov;
      adj = new LinkedList[nov];
      for (int i = 0; i < nov; i++) {
         adj[i] = new LinkedList<>();
      }
   }

   void edge(int nov, int y) {
      adj[nov].add(y);
   }

   void depthfirstsearch(int v) {
      boolean[] visited = new boolean[V];
      DFS(v, visited);
   }

   void DFS(int v, boolean visited[]) {
      visited[v] = true;
      System.out.print(v + " ");
      ListIterator<Integer> it = adj[v].listIterator();
      while (it.hasNext()) {
         int n = it.next();
         if (!visited[n])
            DFS(n, visited);
      }

   }

   public static void main(String[] args) {
      DepthFirstSearch d1 = new DepthFirstSearch(4);
      d1.edge(0, 1);
      d1.edge(0, 2);
      d1.edge(0, 5);
      d1.edge(1, 0);
      d1.edge(1, 2);
      d1.edge(2, 0);
      d1.edge(2, 1);
      d1.edge(2, 3);
      d1.edge(3, 3);
      d1.depthfirstsearch(2);
   }

}
