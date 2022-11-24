package com.sign.problems.grind75.g6invertBinaryTree_226;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.BlockingDeque;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
  }
public class InvertBinaryTree {
    // Approach 1
    private void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }

    public TreeNode invertTree1(TreeNode root) {
        invert(root);
        return root;
    }

    // Approach 2
    public TreeNode invertTreeRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    // Approach 3
    public TreeNode invertTreeStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            // reverse
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            stack.push(node.left);
            stack.push(node.right);
        }
        return root;
    }

    // Approach 4
    public TreeNode invertTreeQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                continue;
            }

            // reverse
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            queue.add(node.left);
            queue.add(node.right);
        }
        return root;
    }

    // Approach 5
    public TreeNode invertTreeDequeBFS(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                continue;
            }

            // reverse
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            queue.add(node.left);
            queue.add(node.right);
        }
        return root;
    }

    // Approach 6
    public TreeNode invertTree(TreeNode root) {
        // deque as stack
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (node == null) {
                continue;
            }

            // reverse
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            queue.push(node.left);
            queue.push(node.right);
        }
        return root;
    }
}
