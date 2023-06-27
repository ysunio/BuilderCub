package org.code.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryInOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(3);
        root.right.right.left.right = new TreeNode(3);

        System.out.println(inorderTraversal(root));
    }

    private static List<Integer> inOrderStore;

    public static List<Integer> inorderTraversal(TreeNode root) {
        inOrderStore = new ArrayList<>();
        traverse(root);
        return inOrderStore;
    }

    private static void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        inOrderStore.add(root.val);
        traverse(root.right);
    }
}
