package org.One;

public class ReverseLinkedList {
    class ListNode{
        int val;
        ListNode next;
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
