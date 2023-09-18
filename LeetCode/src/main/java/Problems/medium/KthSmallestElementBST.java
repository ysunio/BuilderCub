package Problems.medium;

public class KthSmallestElementBST {


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
        root.left.right = new TreeNode(3);

        System.out.println(kthSmallest(root, 2));
    }
    
    private static int smallestNode = -1;
    private static int currentCount = 0;

    public static int kthSmallest(TreeNode root, int k) {
        smallestNode = -1;
        currentCount = 0;
        traverse(root, k);
        return smallestNode;
    }

    private static void traverse(TreeNode root, int k){
        if(root == null) return;
        traverse(root.left, k);
        currentCount++;
        if(currentCount == k && smallestNode == -1){
            smallestNode = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
