package Leetcode;

public class SwapNodeInPair {
    public static void main(String[] args) {
        ListNode listOneNode = new ListNode(1);
        listOneNode.next = new ListNode(2);
        listOneNode.next.next = new ListNode(3);
        listOneNode.next.next.next = new ListNode(4);
        listOneNode.next.next.next.next = new ListNode(5);

        swapPairs(listOneNode).display();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        void display() {
            System.out.print(this.val + " ");
            if (this.next == null) return;
            this.next.display();
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode B = head.next;
        ListNode C = B.next;

        B.next = head;
        head.next = swapPairs(C);
        return B;
    }
}
