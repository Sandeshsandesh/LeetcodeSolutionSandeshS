package com.sign.problems.grind75.g12LinkedListCycle_141;

// https://leetcode.com/problems/linked-list-cycle/

class ListNode {
    int val;
    ListNode next;
}

public class LinkedListCycle {
    public boolean isCyclic(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode tor = head;
        ListNode hare = head;

        while (hare.next != null && hare.next.next != null) {
            tor = tor.next;
            hare = hare.next.next;

            if (tor == hare) {
                return true;
            }
        }
        return false;
    }
}
