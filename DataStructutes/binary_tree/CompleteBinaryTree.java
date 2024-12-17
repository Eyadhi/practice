package binary_tree;
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class CompleteBinaryTree {

    public static TreeNode insertLevelOrder(int[] arr, TreeNode root, int i) {
        // Base case for recursion
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // Insert left child
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

            // Insert right child
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    public static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
    public static int valuesAtLevel(TreeNode root, int level) {
        if (root == null) return 0; // Return empty string if the tree is empty
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentLevel = 0;
        int sum=0;        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            currentLevel++;          
            if (currentLevel == level) { // Check if the current level matches the desired level
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
                    sum+=currentNode.val;                  
                }
                return sum; // Return the values at the desired level
            }           
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();                
                // Enqueue left child
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }               
                // Enqueue right child
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }       
        return 0; // Return empty string if the desired level is not found
    }
    public static void main(String[] args) {
        int[] arr = {12,23,354,32};
        TreeNode root = insertLevelOrder(arr, null, 0);
        System.out.println("In-order traversal of the complete binary tree:");
        printInOrder(root);
        
        int levelValues = valuesAtLevel(root,2);
        System.out.println("Values at level " + 2 + ": " + levelValues);        
    }
}
