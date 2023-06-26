package org.code.medium;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        for (int n : nums)
            System.out.print(n + " >> ");
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int nextHalf = nums.length - k - 1;
        rotate(nums, 0, nextHalf);
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
    }

    private static void rotate(int[] nums, int start, int end) {
        while (start < end) {
            int swap = nums[start];
            nums[start] = nums[end];
            nums[end] = swap;
            start++;
            end--;
        }
    }
}
