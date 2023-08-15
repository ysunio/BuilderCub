package org.One;

public class InvertTree {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        invert(root);
        return root;
    }

    private void invert(TreeNode root){
        if(root == null) return;
        TreeNode leftNode = root.left;
        root.left = root.right;
        root.right = leftNode;
        invert(root.left);
        invert(root.right);
    }
}
