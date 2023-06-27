package org.code.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
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

        System.out.println(rightSideView(root));

        System.out.println(rightSideViewRec(root));
    }

    private static List<Integer> r;

    public static List<Integer> rightSideViewRec(TreeNode root) {
        r = new ArrayList<>();
        trav(root, 0);
        return r;
    }

    private static void trav(TreeNode root, int depth) {
        if (root == null) return;
        if (depth == r.size())
            r.add(root.val);
        trav(root.right, depth + 1);
        trav(root.left, depth + 1);
    }


    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int lastElement = 0;
            while (queueSize-- > 0) {
                TreeNode node = queue.poll();
                lastElement = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(lastElement);
        }
        return res;
    }
}
