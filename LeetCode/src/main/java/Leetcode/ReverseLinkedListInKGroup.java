package Leetcode;

public class ReverseLinkedListInKGroup {

    protected class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;

        int kG = k;
        ListNode current = head;
        ListNode prev = null;
        ListNode nextNode = null;

        int len = 0;
        ListNode tNode = head;
        while (tNode != null) {
            tNode = tNode.next;
            len++;
        }

        if (len < k) return head;

        while (kG > 0 && current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
            kG--;
        }

        if (nextNode != null) head.next = reverseKGroup(nextNode, k);

        return prev;
    }
}
