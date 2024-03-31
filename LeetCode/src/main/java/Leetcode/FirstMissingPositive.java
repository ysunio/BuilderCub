package Leetcode;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{}));
    }

    static int firstMissingPositive(int[] nums) {
        // If 1 is Missing
        boolean missingOne = true;
        for (int num : nums)
            if (num == 1) {
                missingOne = false;
                break;
            }
        if (missingOne) return 1;

        // Setting 0 & Negatives to 1
        for (int idx = 0; idx < nums.length; idx++) if (nums[idx] <= 0) nums[idx] = 1;

        for (int idx = 0; idx < nums.length; idx++) {
            if (Math.abs(nums[idx]) <= nums.length) {
                int indexValue = nums[Math.abs(nums[idx]) - 1];
                nums[Math.abs(nums[idx]) - 1] *= indexValue < 0 ? 1 : -1;
            }
        }
        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] > 0) return idx + 1;
        }

        return nums.length + 1;
    }
}
