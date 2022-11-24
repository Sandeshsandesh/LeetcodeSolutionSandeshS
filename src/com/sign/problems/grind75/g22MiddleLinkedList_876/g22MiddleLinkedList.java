package com.sign.problems.grind75.g22MiddleLinkedList_876;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class g22MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode hare = head;
        ListNode tor = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tor = tor.next;
        }
        return tor;
    }
}