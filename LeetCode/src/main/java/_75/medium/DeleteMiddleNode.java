package _75.medium;

import _75.easy.ReverseList;

public class DeleteMiddleNode {
    public static class ListNode {
        int val;
        DeleteMiddleNode.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, DeleteMiddleNode.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head.next;

        ListNode prevToMiddleNode = head;

        while(fast != null && fast.next != null){
            prevToMiddleNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast == null) prevToMiddleNode.next = slow.next;
        else slow.next = slow.next.next;

        return head;
    }
}
