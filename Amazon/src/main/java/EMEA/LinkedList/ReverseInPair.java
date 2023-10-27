package EMEA.LinkedList;

public class ReverseInPair {
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
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        reverseInPair(head).display();
    }

    private static Node reverseInPair(Node head) {
        if (head == null || head.next == null) return head;
        Node B = head.next;
        Node C = B.next;
        B.next = head;
        head.next = reverseInPair(C);
        return B;
    }

}
