package EMEA.LinkedList;

public class AddTwoNumbers {

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
        Node head = new Node(9);
        head.next = new Node(9);

        Node head2 = new Node(9);
        head2.next = new Node(9);

        addTwoNumbers(head, head2).display();
    }

    private static Node addTwoNumbers(Node head1, Node head2) {
        Node rNode = new Node(-1);
        Node tNode = rNode;

        int carry = 0;
        while (head1 != null && head2 != null) {
            int value = (head1.val + head2.val + carry) % 10;
            tNode.next = new Node(value);
            carry = (head1.val + head2.val + carry) / 10;

            head1 = head1.next;
            head2 = head2.next;
            tNode = tNode.next;
        }

        while (head1 != null) {
            int value = (head1.val + carry) % 10;
            tNode.next = new Node(value);
            carry = (head1.val + carry) / 10;

            head1 = head1.next;
            tNode = tNode.next;
        }

        while (head2 != null) {
            int value = (head2.val + carry) % 10;
            tNode.next = new Node(value);
            carry = (head2.val + carry) / 10;

            head2 = head2.next;
            tNode = tNode.next;
        }

        if(carry != 0)
            tNode.next = new Node(carry);

        return rNode.next;
    }
}
