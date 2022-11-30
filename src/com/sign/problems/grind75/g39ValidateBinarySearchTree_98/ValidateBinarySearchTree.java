package com.sign.problems.grind75.g39ValidateBinarySearchTree_98;

public class ValidateBinarySearchTree {
    Integer cur;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST(root.left)) return false;
        if (cur != null && cur >= root.val) return false;
        cur = root.val;
        return isValidBST(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
}

