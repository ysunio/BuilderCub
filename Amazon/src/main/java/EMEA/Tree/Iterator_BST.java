package EMEA.Tree;

import java.util.ArrayList;
import java.util.List;

public class Iterator_BST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }

    static class BSTIterator {
        List<Integer> elements;
        int currentIdx = 0;

        public BSTIterator(TreeNode root) {
            this.elements = new ArrayList<>();
            this.processTree(root);
        }

        private void processTree(TreeNode root) {
            if (root == null) return;
            processTree(root.left);
            elements.add(root.val);
            processTree(root.right);
        }

        public int next() {
            return elements.get(currentIdx++);
        }

        public boolean hasNext() {
            return currentIdx < elements.size();
        }
    }
}
