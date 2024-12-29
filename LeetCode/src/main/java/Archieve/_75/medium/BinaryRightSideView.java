package Archieve._75.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryRightSideView {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rList = new ArrayList<>();
        if (root == null) return rList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        rList.add(root.val);

        while (!queue.isEmpty()) {
            int nodeSize = queue.size();
            List<Integer> levelEl = new ArrayList<>();
            while (nodeSize > 0) {
                TreeNode cNode = queue.poll();
                assert cNode != null;
                if (cNode.left != null) {
                    queue.add(cNode.left);
                    levelEl.add(cNode.left.val);
                }
                if (cNode.right != null) {
                    queue.add(cNode.right);
                    levelEl.add(cNode.right.val);
                }
                nodeSize--;
            }
            if (!levelEl.isEmpty()) rList.add(levelEl.get(levelEl.size() - 1));
        }

        return rList;
    }
}
