package org.One;

public class BalancedBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced2(root) != -1;
    }

    public int isBalanced2(TreeNode root) {
        if (root == null) return 0;
        int left = isBalanced2(root.left);
        int right = isBalanced2(root.right);

        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right) >= 2) return -1;

        return 1 + Math.max(left, right);
    }
}
