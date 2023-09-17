package Challenges_2022.July;

import java.util.*;

public class ZigZagLevelOrder {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        boolean isEven = true;
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> qStore = new LinkedList<>();

        queue.add(root);
        while (true) {
            int nodeCount = queue.size();
            if (nodeCount == 0)
                break;

            while (nodeCount > 0) {
                TreeNode currNode = queue.poll();
                qStore.add(currNode);
                if (currNode.left != null)
                    queue.add(currNode.left);
                if (currNode.right != null)
                    queue.add(currNode.right);
                nodeCount--;
            }
            ArrayList<Integer> levelOrderStore = new ArrayList<>();
            while (!qStore.isEmpty()) {
                if (isEven) {
                    levelOrderStore.add(qStore.removeFirst().val);
                } else {
                    levelOrderStore.add(qStore.removeLast().val);
                }
            }
            res.add(levelOrderStore);
            if (isEven) {
                isEven = false;
            } else {
                isEven = true;
            }

        }

        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
