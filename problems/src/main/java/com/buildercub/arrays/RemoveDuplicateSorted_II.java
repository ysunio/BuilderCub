package com.buildercub.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RemoveDuplicateSorted_II {

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
        Node head = new Node(20);
        head.next = new Node(20);
        head.next.next = new Node(20);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(30);
        head.next.next.next.next.next = new Node(30);
        head.next.next.next.next.next.next = new Node(50);
        head.next.next.next.next.next.next.next = new Node(50);
        head.next.next.next.next.next.next.next.next = new Node(60);
        return head;
    }

    public static void main(String[] args) {
        removeDuplicates(rCase()).display();
    }

    // 20, 20, 20 , 20, 20, 30, 30, 50, 50, 60 => 60
    static Node removeDuplicates(Node head) {
        Map<Integer, Integer> uniqueElementCount = buildCountHash(head);

        Node rHolder = new Node(-1);
        Node holder = rHolder;
        while (head != null) {
            if (uniqueElementCount.get(head.val) > 1) {
                head = head.next;
                continue;
            }

            Node nextNode = head.next;
            holder.next = head;
            holder.next.next = null;
            holder = holder.next;

            head = nextNode;
        }

        return rHolder.next;
    }

    static Map<Integer, Integer> buildCountHash(Node head) {
        Map<Integer, Integer> map = new HashMap<>();
        while (head != null) {
            map.put(head.val, map.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }
        return map;
    }
}
