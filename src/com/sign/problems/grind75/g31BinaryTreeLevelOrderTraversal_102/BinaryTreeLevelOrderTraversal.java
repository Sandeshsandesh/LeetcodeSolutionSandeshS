package com.sign.problems.grind75.g31BinaryTreeLevelOrderTraversal_102;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Deque<NodeInfo> q = new ArrayDeque<>();
        q.add(new NodeInfo(root, 0));

        while (!q.isEmpty()) {
            NodeInfo nodeInfo = q.remove();

            TreeNode front = nodeInfo.root;
            if (front == null) continue;

            List<Integer> levelList;
            if (nodeInfo.level >= res.size()) {
                levelList = new ArrayList<>();
            } else {
                levelList = res.remove(nodeInfo.level);
            }
            levelList.add(front.val);
            res.add(nodeInfo.level, levelList);

            if (front.left != null) {
                q.add(new NodeInfo(front.left, nodeInfo.level+1));
            }
            if (front.right != null) {
                q.add(new NodeInfo(front.right, nodeInfo.level+1));
            }

        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
}
class NodeInfo{
    TreeNode root;
    int level;

    NodeInfo(TreeNode root, int level) {
        this.root = root;
        this.level = level;
    }
}



