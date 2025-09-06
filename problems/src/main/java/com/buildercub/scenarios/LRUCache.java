package com.buildercub.scenarios;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Info{
        int id;
        public Info(int id){
            this.id = id;
        }

        @Override
        public String toString() {
            return "I am "+id;
        }
    }

    static class Node{
        Info nodeInfo;
        Node next;
        Node prev;

        public Node(){

        }

        public Node(Info nodeInfo){
            this.nodeInfo = nodeInfo;
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU();
        Info node12 = lru.getNode(12);
        System.out.println("Null Expected - Node12 "+ node12);

        lru.putNode(new Info(12));
        lru.putNode(new Info(13));
        lru.putNode(new Info(14));
        lru.putNode(new Info(15));
        lru.putNode(new Info(16));
        lru.putNode(new Info(17));
        System.out.println("Null Expected - Node13 "+ lru.getNode(13));
        System.out.println("Null Expected - Node15 "+ lru.getNode(15));
        lru.putNode(new Info(19));
        lru.putNode(new Info(20));
        lru.putNode(new Info(21));
        System.out.println("Null Expected - Node16 "+ lru.getNode(16));
        System.out.println("Null Expected - Node13 "+ lru.getNode(13));
    }

    static class LRU {

        // Doubly Linked List
        private final Node head = new Node();
        private final Node tail = new Node();

        // Store to Keep Nodes
        final Map<Integer, Node> nodeStore = new HashMap<>();

        // Cache Capacity
        final int capacity = 5;

        public LRU(){
            head.next = tail;
            tail.prev = head;
        }

        Info getNode(int id){
            Node nodeValue = nodeStore.getOrDefault(id, null);
            if(nodeValue == null) return null;
            removeNode(nodeValue); addNodeToHead(nodeValue);
            return nodeValue.nodeInfo;
        }

        void putNode(Info info){
            Info infoPresent = getNode(info.id);
            if(infoPresent != null) return;

            // Add Logic at the Border
            if(nodeStore.size() > capacity) {
                removeNode(tail.prev);
                nodeStore.remove(tail.prev.nodeInfo.id);
            }
            Node newInfoNode = new Node(info);
            addNodeToHead(newInfoNode); nodeStore.put(info.id, newInfoNode);
        }

        void deleteNode(int id){
            if(nodeStore.isEmpty() || !nodeStore.containsKey(id)) return;
            Node currentNode = nodeStore.get(id);
            removeNode(currentNode);
            nodeStore.remove(id);
        }

        // Detach Node
        private void removeNode(Node node){
            Node preNode = node.prev;
            Node nextNode = node.next;
            nextNode.prev = preNode;
            preNode.next = nextNode;
        }

        // Move Node to Head
        private void addNodeToHead(Node node) {
            node.next = head.next;
            head.next = node;
            node.next.prev = node;
        }

    }

}
