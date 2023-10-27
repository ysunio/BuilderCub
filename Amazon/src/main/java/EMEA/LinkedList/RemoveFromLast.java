package EMEA.LinkedList;

public class RemoveFromLast {

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

    static private Node rCase() {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        return head;
    }

    public static void main(String[] args) {
        removeFromLast(rCase(), 0).display();
        removeFromLast(rCase(), 1).display();
        removeFromLast(rCase(), 2).display();
        removeFromLast(rCase(), 3).display();
        removeFromLast(rCase(), 4).display();
        removeFromLast(rCase(), 5).display();
    }

    static Node removeFromLast(Node head, int idxFromEnd) {
        if (idxFromEnd <= 0) return head;
        System.out.println();

        Node prevNode = null;
        Node tNode = head;

        for (int idx = 0; idx < idxFromEnd; idx++) tNode = tNode.next;

        Node rHead = head;
        while (tNode != null) {
            prevNode = rHead;
            rHead = rHead.next;
            tNode = tNode.next;
        }

        if (prevNode != null) prevNode.next = rHead.next;
        if (prevNode == null) return head.next;

        return head;
    }
}
