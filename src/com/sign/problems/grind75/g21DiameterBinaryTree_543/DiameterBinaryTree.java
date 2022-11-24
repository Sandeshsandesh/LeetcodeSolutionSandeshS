package com.sign.problems.grind75.g21DiameterBinaryTree_543;

// https://leetcode.com/problems/diameter-of-binary-tree/

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

public class DiameterBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int maxFromHead = diameter(root) - 1;
        return Math.max(max, maxFromHead);
    }

    private int diameter(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int left = diameter(head.left);
        int right = diameter(head.right);
        if (left + right > max) {
            max = left+right;
        }
        return Math.max(left, right) + 1;
    }

}
