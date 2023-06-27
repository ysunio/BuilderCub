package org.code.medium;

import org.code.easy.Symmetry;

public class ValidBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(3);

        System.out.println(isValidBST(root));
    }


    public static boolean isValidBST(TreeNode root) {
        long maxRange = Long.MAX_VALUE;
        long minRange = Long.MIN_VALUE;
        return isValidBST(root, minRange, maxRange);
    }

    public static boolean isValidBST(TreeNode root, long minRange, long maxRange){
        if(root == null) return true;
        if(root.val <= minRange || root.val >= maxRange) return false;
        return isValidBST(root.left, minRange, root.val) && isValidBST(root.right, root.val, maxRange);
    }
}
