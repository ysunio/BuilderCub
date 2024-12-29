package Archieve.Problems.easy;

public class DiameterOfBinaryTree {

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

        System.out.println(diameterOfBinaryTree(root));
    }

    static int largetDiameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        largetDiameter = 0;
        itr(root);
        return largetDiameter;
    }

    public static int itr(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftCount = itr(root.left);
        int rightCount = itr(root.right);

        largetDiameter = Math.max(largetDiameter, leftCount + rightCount);
        return 1 + Math.max(leftCount, rightCount);
    }
}
