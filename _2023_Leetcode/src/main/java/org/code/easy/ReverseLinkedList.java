package org.code.easy;

public class ReverseLinkedList {

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

        reverseList(head).display();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }

        return prev;
    }
}
