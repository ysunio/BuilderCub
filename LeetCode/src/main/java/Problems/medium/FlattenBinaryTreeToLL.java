package Problems.medium;

public class FlattenBinaryTreeToLL {

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
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        flatten(root);
        while (root.right != null) {
            System.out.println(root.right.val);
            root = root.right;
        }
    }

    public static void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        TreeNode rightNode = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) root = root.right;
        root.right = rightNode;
        flatten(root.right);
    }
}
