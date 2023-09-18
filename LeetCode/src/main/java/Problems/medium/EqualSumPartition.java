package Problems.medium;

public class EqualSumPartition {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int x : nums) totalSum += x;
        if (totalSum % 2 != 0) return false;
        int[][] mem = new int[nums.length][totalSum / 2 + 1];
        return partition(nums, totalSum / 2, 0, mem);
    }

    public static boolean partition(int[] nums, int target, int idx, int[][] mem) {
        if (target == 0) return true;
        if (idx >= nums.length || target < 0) return false;
        if (mem[idx][target] != 0) return mem[idx][target] == -1 ? false : true;
        boolean foundSum = partition(nums, target, idx + 1, mem) || partition(nums, target - nums[idx], idx + 1, mem);

        if (foundSum)
            mem[idx][target] = 1;
        else
            mem[idx][target] = -1;

        return foundSum;
    }
}
