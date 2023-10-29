package EMEA.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftLeaf {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        System.out.println(leftLeaf(root).val);
    }

    static Node leftLeaf(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node leftMostElement = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            leftMostElement = null;

            while (size > 0) {
                Node cNode = queue.poll();
                if (leftMostElement == null) leftMostElement = cNode;

                if (cNode.left != null) queue.add(cNode.left);
                if (cNode.right != null) queue.add(cNode.right);

                size--;
            }

        }

        return leftMostElement;
    }

}
