package _75.medium;

public class RemoveNthFromLast {

    public static class ListNode {
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
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (prev != null) prev.next = slow.next;
        if (prev == null) return slow.next;

        return head;
    }
}
