package com.sign.problems.AddTwoNumbers_2;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class AddTwoNumbersMain {
    public static void main(String[] args) {
        int[] l1_array = {2,4,3};
        int[] l2_array = {5,6,4};

        ListNode l1 = arrayToList(l1_array);
        ListNode l2 = arrayToList(l2_array);

        ListNode sumNode = new AddTwoNumbersSoution().addTwoNumbers( l1, l2);

        printNode(sumNode);
    }

    private static void printNode(ListNode sumNode) {
        ListNode temp = sumNode;
        while (temp!=null) {
            System.out.print(" " + temp.val + " -> ");
            temp = temp.next;
        }
    }

    private static ListNode arrayToList(int[] l1_array) {
        ListNode NewNode = new ListNode(0);
        ListNode temp = NewNode;
        for (int value :
                l1_array) {
            temp.next = new ListNode(value);
            temp = temp.next;
        }
        return NewNode.next;
    }
}
