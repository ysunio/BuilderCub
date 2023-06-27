package org.code.medium;

import org.code.easy.ReverseLinkedList;

public class RemoveNthNode {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        void display() {
            System.out.print(" >> " + this.val);
            if (this.next != null) this.next.display();
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

        removeNthFromEnd(head, 3).display();
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = len(head);
        ListNode holder = head;
        int idx = len - n;
        if (idx == 0) return head.next;
        ListNode prev = null;
        while (idx-- > 0) {
            prev = head;
            head = head.next;
        }
        if (prev != null && head != null) prev.next = head.next;
        return holder;
    }

    private static int len(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
