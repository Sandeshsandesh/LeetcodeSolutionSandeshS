package com.sign.problems.grind75.g32CloneGraph_133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);

        List<Node> newNbrs = new ArrayList<>();
        for (Node nbr : node.neighbors) {
            newNbrs.add(cloneGraph(nbr));
        }
        newNode.neighbors = newNbrs;
        return newNode;
    }

}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

/*class Node {
    int val;
    List<Node> nbrs;

    public Node(int val) {
        this.val = val;
    }

    public void setNbrs(List<Node> nbrs) {
        this.nbrs = nbrs;
    }
}*/
