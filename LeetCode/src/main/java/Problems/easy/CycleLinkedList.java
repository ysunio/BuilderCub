package Problems.easy;

public class CycleLinkedList {
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
        ListNode headOne = new ListNode(10);
        headOne.next = new ListNode(20);
        headOne.next.next = new ListNode(30);
        headOne.next.next.next = new ListNode(40);
        headOne.next.next.next.next = headOne.next.next;
        System.out.println(hasCycle(headOne));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
