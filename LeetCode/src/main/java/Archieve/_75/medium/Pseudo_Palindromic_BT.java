package Archieve._75.medium;

public class Pseudo_Palindromic_BT {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int rCounter = 0;
    private static int[] counterArray = new int[10];

    public static int pseudoPalindromicPaths(TreeNode root) {
        rCounter = 0;
        counterArray = new int[10];
        solve(root);
        return rCounter;
    }

    private static void solve(TreeNode root) {
        if (root == null) return;

        int currentNode = root.val;
        counterArray[currentNode]++;
        if (root.left == null && root.right == null) {
            if (isHavingPseudoPalindrome(counterArray)) rCounter++;
            counterArray[currentNode]--;
            return;
        }
        solve(root.left);
        solve(root.right);
        counterArray[currentNode]--;
    }

    private static boolean isHavingPseudoPalindrome(int[] countOrder) {
        boolean hasOne = false;
        for (int x : countOrder) {
            if (hasOne && x % 2 != 0) return false;
            if (x % 2 != 0) hasOne = true;
        }
        return true;
    }
}
