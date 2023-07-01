package org.code.medium;

public class SortList {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        void display() {
            System.out.print(" >> " + this.val);
            if (this.next != null) this.next.display();
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(50);
        head.next = new ListNode(20);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(80);

        sortList(head).display();
    }

    static ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode rightHalf = getMid(head);

        ListNode left = sortList(head);
        ListNode right = sortList(rightHalf);

        return merge(left, right);
    }

    static ListNode merge(ListNode left, ListNode right) {
        if (left == null && right == null) return null;
        if (left == null || right == null) return left == null ? right : left;

        ListNode mergedList = new ListNode(-1);
        ListNode tHold = mergedList;

        while (left != null && right != null) {
            if (left.val < right.val) {
                ListNode nextLeft = left.next;
                left.next = null;
                tHold.next = left;
                left = nextLeft;
                tHold = tHold.next;
            } else {
                ListNode nextRight = right.next;
                right.next = null;
                tHold.next = right;
                right = nextRight;
                tHold = tHold.next;
            }
        }

        if (left != null) tHold.next = left;
        if (right != null) tHold.next = right;

        return mergedList.next;
    }

    static ListNode getMid(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) prev.next = null;
        return slow;
    }
}
