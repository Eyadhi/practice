package graphs;

class Graph {
	private int n;
	private int[][] g;

	Graph(int x) {
		this.n = x;
		int i, j;
		g = new int[n][n];
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				g[i][j] = 0;
			}
		}
	}

	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Adjacent Matrix Representation");
		for (int[] row : g) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	public void addEdge(int x, int y) {
		// TODO Auto-generated method stub
		if ((x >= n) || (y > n)) {
			System.out.println("Vertex does not exists");
		}
		if (x == y) {
			System.out.println("Same vertex");
		} else {
			g[x][y] = 1;
			g[y][x] = 1;
		}
	}

	public void addVertex() {
		n++;
		int i;
		for (i = 0; i < n; i++) {
			g[i][n - 1] = 0;
			g[n - 1][i] = 0;
		}
	}

	public void removeVertex(int x) {
		if (x > n) {
			System.out.println("vertex not present");
		} else {
			int i;
			while (x < n) {
				for (i = 0; i < n; i++) {
					g[i][x] = g[i][x + 1];
				}
				for (i = 0; i < n; i++) {
					g[x][i] = g[x + 1][i];
				}
				x++;
			}
			n--;
		}
	}
}

public class AdjacentMatrixRep {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph obj = new Graph(4);
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		obj.addEdge(1, 2);
		obj.addEdge(2, 3);
		obj.display();

		/*
		 * obj.addVertex();
		 * obj.addEdge(4, 1);
		 * obj.addEdge(4, 3);
		 * obj.display();
		 */

		obj.removeVertex(1);
		obj.display();
	}
}
