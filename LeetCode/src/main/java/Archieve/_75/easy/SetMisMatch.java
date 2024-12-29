package Archieve._75.easy;

public class SetMisMatch {
    public int[] findErrorNums(int[] nums) {
        int totalSumNeeds = 0;
        int totalSum = 0;
        int duplicateNumber = 0;

        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[Math.abs(nums[idx]) - 1] < 0) {
                duplicateNumber = Math.abs(nums[idx]);
                break;
            }
            nums[Math.abs(nums[idx]) - 1] *= -1;
        }

        for (int idx = 0; idx < nums.length; idx++) {
            totalSumNeeds += idx + 1;
            totalSum += Math.abs(nums[idx]);
        }

        return new int[]{duplicateNumber, totalSumNeeds - (totalSum - duplicateNumber)};
    }
}
