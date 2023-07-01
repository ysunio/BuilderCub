package org.code.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyNodeRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        void display() {
            System.out.print(this.val + " > ");
            if (this.next != null)
                this.next.display();
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.random = head.next;

        copyRandomList(head).display();
    }

    public static Node copyRandomList(Node head) {
        Map<Node, Node> nodeStore = new HashMap<>();
        Node tNode = head;

        while (head != null) {
            Node nNode = new Node(head.val);
            nodeStore.put(head, nNode);
            head = head.next;
        }

        for (Map.Entry<Node, Node> nodeMap : nodeStore.entrySet()) {
            nodeMap.getValue().next = nodeStore.getOrDefault(nodeMap.getKey().next, null);
            nodeMap.getValue().random = nodeStore.getOrDefault(nodeMap.getKey().random, null);
        }

        return nodeStore.get(tNode);
    }
}
