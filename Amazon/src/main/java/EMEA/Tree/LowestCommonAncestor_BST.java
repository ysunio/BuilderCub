package EMEA.Tree;

public class LowestCommonAncestor_BST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println(lowestCommonAncestor(root, root.left.right.left, root.right.left).val);
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        TreeNode inLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode inRight = lowestCommonAncestor(root.right, p, q);

        if (root == p || root == q) return root;
        if (inLeft != null && inRight != null) return root;

        return inRight == null ? inLeft : inRight;
    }
}
