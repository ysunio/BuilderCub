package EMEA.LinkedList;

public class RotateList {
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

        int len() {
            if (this.next == null) return 1;
            return 1 + this.next.len();
        }
    }

    private static Node genNode() {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        return head;
    }

    public static void main(String[] args) {
        rotateList(genNode(), 1).display();
        System.out.println();
        rotateList(genNode(), 2).display();
        System.out.println();
        rotateList(genNode(), 3).display();
        System.out.println();
        rotateList(genNode(), 4).display();
        System.out.println();
        rotateList(genNode(), 5).display();
        System.out.println();
        rotateList(genNode(), 6).display();
    }

    private static Node rotateList(Node head, int rotateTimes) {
        int linkedListLen = head.len();
        int endSwap = linkedListLen - (rotateTimes % linkedListLen);
        if (endSwap == linkedListLen || endSwap == 0) return head;

        Node headHolder = head;
        Node prev = null;
        for (int idx = 0; idx < endSwap; idx++) {
            prev = head;
            head = head.next;
        }
        if (prev != null) prev.next = null;
        Node segmentBreak = head;
        Node rH = segmentBreak;

        while (rH.next != null) rH = rH.next;
        rH.next = headHolder;
        return segmentBreak;
    }
}
