package binary_tree;

import java.util.*;

class Node {
	int key;
	Node left, right;

	Node(int key) {
		this.key = key;
		left = right = null;
	}
}

class Treetraversal {
	Node root;

	Treetraversal() {
		root = null;
	}

	public void preorder(Node n) {
		if (n != null) {
			System.out.print(n.key + " ");
			preorder(n.left);
			preorder(n.right);
		}
	}

	public void postorder(Node n) {
		if (n != null) {
			postorder(n.left);
			postorder(n.right);
			System.out.print(n.key + " ");
		}
	}

	public void inorder(Node n) {
		if (n != null) {
			inorder(n.left);
			System.out.print(n.key + " ");
			inorder(n.right);
		}
	}

	public void inorder_without_rec() {
		if (root == null)
			return;
		Node temp = root;
		Stack<Node> s1 = new Stack<>();
		while (!s1.isEmpty() || temp != null) {
			if (temp != null) {
				s1.push(temp);
				temp = temp.left;
			} else {
				temp = (Node) s1.pop();
				System.out.print(temp.key + " ");
				temp = temp.right;
			}
		}
	}

	public void preorder_without_rec() {
		if (root == null)
			return;
		Stack<Node> s1 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			Node temp = s1.pop();
			System.out.print(temp.key + " ");
			if (temp.right != null)
				s1.push(temp.right);
			if (temp.left != null)
				s1.push(temp.left);
		}
	}

	public void postorder_without_rec() {
		if (root == null)
			return;
		Stack<Node> s1 = new Stack<>();
		Node current = root;
		while (!s1.isEmpty() || current != null) {
			if (current != null) {
				s1.push(current);
				current = current.left;
			} else {
				Node temp = s1.peek().right;
				if (temp == null) {
					temp = s1.pop();
					System.out.print(temp.key + " ");
					while (!s1.isEmpty() && temp == s1.peek().right) {
						temp = s1.pop();
						System.out.print(temp.key + " ");
					}
				} else {
					current = temp;
				}
			}
		}
	}

	public void levelOrder() {
		if (root == null) {
			return;
		}
		Queue<Node> q1 = new LinkedList<>();
		q1.offer(root);
		while (!q1.isEmpty()) {
			Node temp = q1.poll();
			System.out.print(temp.key + " ");
			if (temp.left != null) {
				q1.offer(temp.left);
			}
			if (temp.right != null) {
				q1.offer(temp.right);
			}
		}
	}

	public int findMax() {
		return findMax(root);
	}

	public int findMax(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int result = root.key;
		int left = findMax(root.left);
		int right = findMax(root.right);
		if (left > result) {
			result = left;
		}
		if (right > result) {
			result = right;
		}
		return result;
	}

	public boolean isSymmetric(Node root) {
		return check(root, root);
	}

	public boolean check(Node t1, Node t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		return t1.key == t2.key && check(t1.left, t2.right) && check(t1.right, t2.left);
	}

	public boolean isIdentical(Node root) {
		return isIdentical(root, root);
	}

	public boolean isIdentical(Node t1, Node t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 == null || t2 == null)
			return false;
		return t1.key == t2.key && isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
	}

	public Node MirrorTree(Node root) {
		if (root == null) {
			return root;
		}
		Node left = MirrorTree(root.left);
		Node right = MirrorTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

	public int MaxDepth(Node root) {
		if (root == null) {
			return 0;
		}
		int left = MaxDepth(root.left);
		int right = MaxDepth(root.right);
		return 1 + Math.max(left, right);
	}

	public int Diameter(Node root) {
		if (root == null) {
			return 0;
		}
		int left = MaxDepth(root.left);
		int right = MaxDepth(root.right);
		return left + right + 1;
	}

	public boolean isBalanced(Node root) {
		if (root == null) {
			return true;
		}
		int left = MaxDepth(root.left);
		int right = MaxDepth(root.right);
		if (Math.abs(left - right) <= 1) {
			return true;
		}
		return false;
	}
}

public class sample {
	public static void main(String[] args) {
		Treetraversal t1 = new Treetraversal();
		t1.root = new Node(1);
		t1.root.left = new Node(5);
		t1.root.right = new Node(3);
		t1.root.left.left = new Node(2);
		t1.root.left.right = new Node(7);
		t1.root.right.left = new Node(4);

		/*
		 * System.out.println("Preorder Traversal");
		 * t1.preorder(t1.root);
		 * System.out.println("\nPostOrder Traversal");
		 * t1.postorder(t1.root);
		 * System.out.println("\nInorder Traversal");
		 * t1.inorder(t1.root);
		 * /*System.out.println("\nInorder Traversal without recursion");
		 * t1.inorder_without_rec();
		 * System.out.println("\nPreorder Traversal without recursion");
		 * t1.preorder_without_rec();
		 * System.out.println("\nPostOrder Traversal without recursion");
		 * t1.postorder_without_rec();
		 * System.out.println("\n LevelOrder traversal");
		 * t1.levelOrder();
		 * int res=t1.findMax();
		 * System.out.println("maximum value"+res);
		 * if(t1.isSymmetric(t1.root))
		 * System.out.println("Symmetric");
		 * else
		 * System.out.println("not Symmetric");
		 * int height=t1.MaxDepth(t1.root);
		 * System.out.println(height);
		 * System.out.println(t1.isIdentical(t1.root));
		 * t1.MirrorTree(t1.root);
		 * System.out.println("Inorder");
		 * t1.inorder(t1.root);
		 */
		System.out.println(t1.Diameter(t1.root));
		System.out.println(t1.isBalanced(t1.root));
	}
}
