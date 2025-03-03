package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstSearch {
    int v;
    ArrayList<Integer> t1[];

    BreadthFirstSearch(int noofvertex) {
        v = noofvertex;
        t1 = new ArrayList[v];
        for (int i = 0; i < noofvertex; i++) {
            t1[i] = new ArrayList<>();
        }
    }

    void edge(int x, int y) {
        t1[x].add(y);
    }

    void breadthFirstSearch(int sourcevertex) {
        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        visited[sourcevertex] = true;
        q.add(sourcevertex);
        while (!q.isEmpty()) {
            sourcevertex = q.poll();
            System.out.print(sourcevertex + " ");
            for (int v : t1[sourcevertex])
                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BreadthFirstSearch g1 = new BreadthFirstSearch(6);
        g1.edge(0, 1);
        g1.edge(0, 2);
        g1.edge(0, 5);
        g1.edge(1, 0);
        g1.edge(1, 2);
        g1.edge(2, 0);
        g1.edge(2, 1);
        g1.edge(2, 3);
        g1.edge(2, 4);
        g1.edge(3, 2);
        g1.edge(4, 2);
        g1.edge(4, 5);
        g1.edge(5, 0);
        g1.edge(5, 4);
        g1.breadthFirstSearch(0);
    }
}
