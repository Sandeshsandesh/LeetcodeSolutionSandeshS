package com.sign.problems.grind75.g11BalancedBinaryTree_110;

// https://leetcode.com/problems/balanced-binary-tree/

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



public class BalancedBinaryTree {

    static class BalHt {
        boolean isBalanced;
        int height;

        BalHt(boolean isBalananced, int height) {
            this.isBalanced = isBalananced;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {
        BalHt balHt = dfs(root);
        return balHt.isBalanced;
    }

    private BalHt dfs(TreeNode root) {
        if (root == null) {
            return new BalHt(true, 0);
        }
        BalHt balHtLeft = dfs(root.left);
        if (!balHtLeft.isBalanced) {
            return balHtLeft;
        }
        BalHt balHtRight = dfs(root.right);
        if (!balHtRight.isBalanced) {
            return balHtRight;
        }
        boolean isBalanced = Math.abs(balHtLeft.height - balHtRight.height) < 2;
        int maxHeight = Math.max(balHtLeft.height, balHtRight.height);
        return new BalHt(isBalanced, 1 + maxHeight);
    }

}
