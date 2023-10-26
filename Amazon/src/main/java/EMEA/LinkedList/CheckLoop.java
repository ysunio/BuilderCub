package EMEA.LinkedList;

public class CheckLoop {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = head.next.next;

        System.out.println(hasLoopWithRecursion(head, head.next));
        System.out.println(hasLoop(head));
    }

    // Iterative
    private static boolean hasLoop(Node head) {
        Node slowPointer = head;
        Node fastPointer = head.next;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) return true;
        }
        return false;
    }

    // Recursion
    private static boolean hasLoopWithRecursion(Node cNode, Node twoStepNode) {
        if (cNode == null || twoStepNode == null || twoStepNode.next == null) return false;
        if (cNode == twoStepNode) return true;
        return hasLoopWithRecursion(cNode.next, twoStepNode.next.next);
    }

}
