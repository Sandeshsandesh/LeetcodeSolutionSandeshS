package com.sign.problems.math.AddTwoNumbers_2;

public class AddTwoNumbersSoution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum, carry=0;
        ListNode ResultNode = new ListNode(0);          //dummyRoot
        ListNode ResultPtr = ResultNode;

        while ( l1 != null || l2 != null) {
            if (l1 == null){
                sum = l2.val + carry;
                l2 = l2.next;
            }
            else if ( l2 == null){
                sum = l1.val + carry;
                l1 = l1.next;
            }
            else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum %= 10;
            ResultPtr.next = new ListNode(sum);
            ResultPtr = ResultPtr.next;
        }
        if (carry !=0)
            ResultPtr.next = new ListNode(carry);
        return ResultNode.next;                          //return the next of dummyRoot
    }
}
