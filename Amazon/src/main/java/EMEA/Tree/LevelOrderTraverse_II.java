package EMEA.Tree;

import java.util.*;

public class LevelOrderTraverse_II {

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

        System.out.println(levelOrderBottom(root));
    }

    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rStore = new ArrayList<>();
        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cSize = queue.size();
            List<Integer> level = new ArrayList<>();
            while (cSize > 0) {
                TreeNode cNode = queue.poll();
                level.add(cNode.val);

                if (cNode.left != null) queue.add(cNode.left);
                if (cNode.right != null) queue.add(cNode.right);
                cSize--;
            }
            rStore.add(level);
        }
        Collections.reverse(rStore);
        return rStore;
    }
}
