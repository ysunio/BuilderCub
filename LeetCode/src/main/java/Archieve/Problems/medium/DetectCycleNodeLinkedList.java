package Archieve.Problems.medium;

public class DetectCycleNodeLinkedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(10);
        listNode.next = new ListNode(20);
        listNode.next.next = new ListNode(30);
        listNode.next.next.next = new ListNode(40);
        listNode.next.next.next.next = new ListNode(50);
        listNode.next.next.next.next.next = listNode.next.next;

        System.out.println(detectCycle(listNode).val);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        if (fast == null || fast.next == null) return null;

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return slow;
    }
}
