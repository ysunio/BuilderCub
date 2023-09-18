package Problems.easy;

public class InvertBinaryTree {

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

        System.out.println(invertTree(root));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invert(root);
        return root;
    }

    private static void invert(TreeNode root) {
        if (root == null) return;
        TreeNode leftNode = root.left;
        root.left = root.right;
        root.right = leftNode;
        invert(root.left);
        invert(root.right);
    }
}
