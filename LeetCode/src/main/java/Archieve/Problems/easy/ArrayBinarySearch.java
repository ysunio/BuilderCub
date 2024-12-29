package Archieve.Problems.easy;

public class ArrayBinarySearch {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public void display(){
            System.out.print(this.val+" ");
            if(this.left != null) this.left.display();
            if(this.right != null) this.right.display();
        }
    }

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10,-3,0,5,9}).display();
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return make(nums, 0, nums.length - 1);
    }

    private static TreeNode make(int[] nums, int start, int end){
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        int midElement = nums[mid];
        TreeNode root = new TreeNode(midElement);

        root.left = make(nums, start, mid - 1);
        root.right = make(nums, mid + 1, end);

        return root;
    }
}
