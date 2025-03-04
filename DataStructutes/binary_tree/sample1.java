package binary_tree;

class Binary_Search_Tree {
	Node root;

	Binary_Search_Tree() {
		root = null;
	}

	void insertkey(int key) {
		root = insertNode(root, key);
	}

	public Node insertNode(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		} else if (key < root.key) {
			root.left = insertNode(root.left, key);
		} else if (key > root.key) {
			root.right = insertNode(root.right, key);
		}
		return root;
	}

	public Node SearchNode(Node root, int value) {
		if (root == null)
			return null;
		if (root.key == value)
			return root;
		else if (value < root.key)
			return SearchNode(root.left, value);
		else
			return SearchNode(root.right, value);
	}

	public Node deleteNode(Node root, int value) {
		if (root == null)
			return root;
		if (value > root.key) {
			root.right = deleteNode(root.right, value);
		} else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			root.key = minimumValue(root.left);
			root.left = deleteNode(root.left, root.key);
		}
		return root;
	}

	public int minimumValue(Node root) {
		int min;
		for (min = root.key; root.left != null; root = root.left)
			min = root.left.key;
		return min;
	}

	public int maximumValue(Node root) {
		int max;
		for (max = root.key; root.right != null; root = root.right)
			max = root.right.key;
		return max;
	}

	void preorder(Node n) {
		if (n != null) {
			System.out.print(n.key + " ");
			preorder(n.left);
			preorder(n.right);
		}
		// System.out.println();
	}

	void postorder(Node n) {
		if (n != null) {
			postorder(n.left);
			postorder(n.right);
			System.out.print(n.key + " ");
		}
		// System.out.println();
	}

	void inorder(Node n) {
		if (n != null) {
			inorder(n.left);
			System.out.print(n.key + " ");
			inorder(n.right);
		}
		// System.out.println();
	}

	public boolean isValid(Node root, long min, long max) {
		if (root == null) {
			return true;
		}
		if (root.key <= min || root.key >= max) {
			return false;
		}
		boolean left = isValid(root.left, min, root.key);
		if (left) {
			boolean right = isValid(root.right, root.key, max);
			return right;
		}
		return false;
	}
}

public class sample1 {
	public static void main(String[] args) {
		Binary_Search_Tree t1 = new Binary_Search_Tree();
		t1.insertkey(1);
		t1.insertkey(3);
		t1.insertkey(2);
		t1.insertkey(7);
		t1.insertkey(4);
		/*
		 * t1.postorder(t1.root);
		 * System.out.println();
		 * t1.inorder(t1.root);
		 * Node node=t1.SearchNode(t1.root,17);
		 * if(node !=null)
		 * System.out.println("\nelement is present");
		 * else
		 * System.out.println("\nelement is not present");
		 * t1.deleteNode(t1.root,7);
		 * t1.inorder(t1.root);
		 * if(t1.isValid(t1.root,Long.MIN_VALUE,Long.MAX_VALUE)) {
		 * System.out.println("valid");
		 * }
		 * else {
		 * System.out.println("Invalid");
		 * }
		 */
		int maximum1 = t1.maximumValue(t1.root);
		System.out.println(maximum1);
		int minimum1 = t1.minimumValue(t1.root);
		System.out.println(minimum1);
	}
}
