package EMEA.Tree;

import java.util.*;

public class AddOneRow {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(levelOrderBottom(root, 2, 1));
    }

    private static TreeNode levelOrderBottom(TreeNode root, int depth, int value) {
        if (root == null) return null;
        if (depth == 1) {
            TreeNode r = new TreeNode(value);
            r.left = root;
            return r;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cDepth = 0;

        List<TreeNode> level = new ArrayList<>();

        while (!queue.isEmpty()) {
            int cSize = queue.size();

            while (cSize > 0 && cDepth != (depth - 1)) {
                cDepth++;

                TreeNode cNode = queue.poll();
                level.add(cNode);

                if (cNode.left != null) queue.add(cNode.left);
                if (cNode.right != null) queue.add(cNode.right);
                cSize--;
            }

        }

        for (TreeNode n : level) {
            TreeNode left = n.left;
            TreeNode right = n.right;
            n.left = new TreeNode(value);
            n.right = new TreeNode(value);
            n.left.left = left;
            n.right.right = right;
        }

        return root;
    }
}
