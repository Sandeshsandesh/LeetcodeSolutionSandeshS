package com.sign.problems.grind75.g10LowestCommonAncestor_235;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class LowestCommonAncestor {
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lca(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lca(root.right, p, q);
        }
        /*
        if (search(root, p) && search(root, q)) {
        return root;
        }
        return null;
        */
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }


}
