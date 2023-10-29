package EMEA.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxValueAtEachRow {
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
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(maxValue(root));
    }

    static List<Integer> maxValue(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode cNode = queue.poll();
                maxValue = Math.max(maxValue, cNode.val);
                if (cNode.left != null) queue.add(cNode.left);
                if (cNode.right != null) queue.add(cNode.right);
                size--;
            }
            res.add(maxValue);
        }

        return res;
    }
}
