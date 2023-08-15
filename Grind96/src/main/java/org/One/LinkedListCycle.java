package org.One;

public class LinkedListCycle {

    class ListNode{
        int val;
        ListNode next;
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(
                fast != null &&
                        fast.next != null &&
                        fast != slow){

            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == slow;
    }
}
