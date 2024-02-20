package _75.easy;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int requiredSum = 0;
        int actualSum = 0;

        for (int idx = 0; idx < nums.length; idx++) {
            actualSum ^= nums[idx];
            requiredSum ^= idx + 1;
        }

        return requiredSum == actualSum ? 0 : requiredSum ^ actualSum;
    }
}
