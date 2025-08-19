package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessorOfANode {
    
    public static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode successor(TreeNode root, int key) {
        if (root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            //just straight BFS (no for loop needed to maintain the level)
            if (current.left != null) q.add(current.left);
            if (current.right != null) q.add(current.right);

            if (current.val == key) {
                return q.peek();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LevelOrderSuccessorOfANode tree = new LevelOrderSuccessorOfANode();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);


        int key = 6;
        TreeNode result = tree.successor(root, key);

        if (result != null) {
            System.out.println("Level order successor of " + key + " is: " + result.val);
        } else {
            System.out.println("No successor found for " + key);
        }
    }
}
