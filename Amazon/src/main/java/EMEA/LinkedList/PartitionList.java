package EMEA.LinkedList;

public class PartitionList {

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
        head.next = new Node(30);
        head.next.next = new Node(50);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(50);
        return head;
    }

    public static void main(String[] args) {
        partitionList(rCase(), 30).display();
        System.out.println();
        partitionList(rCase(), 20).display();
        System.out.println();
        partitionList(rCase(), 10).display();
    }

    // 10, 30, 50, 20, 50 => 10, 30, 20, 50, 50
    static Node partitionList(Node head, int partitionNumber) {
        Node lHolder = new Node(-1);
        Node leftHolder = lHolder;

        Node rHolder = new Node(-1);
        Node rightHolder = rHolder;

        while (head != null) {
            Node nextHead = head.next;

            if (head.val >= partitionNumber) {
                rightHolder.next = head;
                rightHolder.next.next = null;
                rightHolder = rightHolder.next;
            } else {
                leftHolder.next = head;
                leftHolder.next.next = null;
                leftHolder = leftHolder.next;
            }

            head = nextHead;
        }

        leftHolder.next = rHolder.next;

        return lHolder.next;
    }
}
