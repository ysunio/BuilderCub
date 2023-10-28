package EMEA.LinkedList;

//  [1,2,3,4,5], left = 2, right = 4
//  [1,4,3,2,5]
public class ReverseList_II {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        void display() {
            System.out.print(this.val + " ");
            if (this.next == null) return;
            this.next.display();
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        reverseInRange(head, 2, 4).display();
    }

    private static Node reverseInRange(Node head, int sIdx, int eIdx) {
        if (sIdx == eIdx) return head;
        eIdx++;
        // Find Node withinRange

        Node actualHead = head;
        Node prevHead = null;

        for (int idx = 1; idx < sIdx; idx++) {
            prevHead = head;
            head = head.next;
        }

        if (prevHead == null) actualHead = null;
        if (prevHead != null) prevHead.next = null;

        Node segmentNode = head;

        prevHead = null;
        for (int idx = 0; idx < (eIdx - sIdx); idx++) {
            prevHead = head;
            head = head.next;
        }
        if (prevHead != null) prevHead.next = null;

        Node remainingNode = head;

        Node reversedSegment = reverse(segmentNode);

        Node result = new Node(-1);
        Node rH = actualHead;
        if (rH != null) result.next = rH;

        while (rH != null && rH.next != null) rH = rH.next;
        if (rH == null) {
            rH = reversedSegment;
            result.next = reversedSegment;
        } else
            rH.next = reversedSegment;

        while (rH.next != null) rH = rH.next;
        rH.next = remainingNode;

        return result.next;
    }

    private static Node reverse(Node head) {
        if (head == null) return null;
        Node prev = null;
        while (head != null) {
            Node nH = head.next;
            head.next = prev;
            prev = head;
            head = nH;
        }
        return prev;
    }

}
