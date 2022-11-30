package com.sign.problems.grind75.g35ImplementTrie_208;

class Node {
    // List<Node> childn;
    Node[] childn;
    boolean isEnd;

    Node() {
// childn = new ArrayList<>(26);
        childn = new Node[26];
        isEnd = false;
    }
}

public class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) return;

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // if (cur.childn.get(c - 'a') == null) {
            if (cur.childn[c - 'a'] == null) {
                Node newNode = new Node();
                // cur.childn.set(c-'a', newNode);
                cur.childn[c - 'a'] = newNode;
                cur = newNode;
            } else {
                cur = cur.childn[c - 'a'];
            }
        }
        cur.isEnd = true;

    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) return true;

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.childn[c - 'a'] == null) {
                return false;
            }
            cur = cur.childn[c - 'a'];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String word) {
        if (word == null || word.length() == 0) return true;

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.childn[c - 'a'] == null) {
                return false;
            }
            cur = cur.childn[c - 'a'];
        }
        return true;
    }

}