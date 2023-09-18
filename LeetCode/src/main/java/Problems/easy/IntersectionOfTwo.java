package Problems.easy;

public class IntersectionOfTwo {

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
        headOne.next.next.next.next = new ListNode(50);

        ListNode headTwo = new ListNode(100);
        headTwo.next = new ListNode(120);
        headTwo.next.next = new ListNode(130);
        headTwo.next.next.next = headOne.next.next.next;
        headTwo.next.next.next.next = headOne.next.next.next.next;

        System.out.println(getIntersectionNode_Len(headOne, headTwo).val);
    }

    public static ListNode getIntersectionNode_Len(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);

        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private static int len(ListNode head) {
        int listLen = 0;
        while (head != null) {
            listLen++;
            head = head.next;
        }
        return listLen;
    }

    public static ListNode getIntersectionNode_Rev(ListNode headA, ListNode headB) {
        ListNode reverseA = reverse(headA);
        ListNode reverseB = reverse(headB);

        ListNode commonNode = null;
        while (reverseA == reverseB && reverseA != null) {
            commonNode = reverseA;
            reverseA = reverseA.next;
            reverseB = reverseB.next;
        }

        return commonNode;
    }

    private static ListNode reverse(ListNode head) {
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
