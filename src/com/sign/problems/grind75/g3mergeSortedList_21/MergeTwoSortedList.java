package com.sign.problems.grind75.g3mergeSortedList_21;

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class MergeTwoSortedList {
    // Approach1: compare first and second and point cur(head) to minimum of two and move to next of minimum
    public ListNode mergeTwoListsItirative(ListNode first, ListNode second) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (first != null && second != null) {
            if (first.val < second.val) {
                cur.next = first;
                first = first.next;
            } else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }

        if (first != null) {
            cur.next = first;
        } else if (second != null) {
            cur.next = second;
        }

        return head.next;
    }

    // Approach2: Recursion 
    public ListNode mergeTwoLists(ListNode first, ListNode second) {
        ListNode head;
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        if (first.val < second.val) {
            first.next = mergeTwoLists(first.next, second);
            return first;
        } else {
            second.next = mergeTwoLists(first, second.next);
            return second;
        }
    }
}