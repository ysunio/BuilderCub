package EMEA.Tree;

import com.sun.source.tree.Tree;

//  [1,2,3]
//  25
public class LeafSum {

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

        currentSum = 0;
        totalSum = 0;
        leafSum(root);
        System.out.println(totalSum);
    }

    static int totalSum = 0;
    static int currentSum = 0;

    static void leafSum(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            totalSum += currentSum * 10 + root.val;
        }

        currentSum = currentSum * 10 + root.val;
        leafSum(root.left);
        leafSum(root.right);

        currentSum = currentSum / 10;
    }

}
