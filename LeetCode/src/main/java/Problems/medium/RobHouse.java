package Problems.medium;

import java.util.Arrays;

public class RobHouse {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob_DP(new int[]{1, 2, 3, 1}));
    }

    public static int rob_DP(int[] nums) {
        int len = nums.length;
        int[][] mem = new int[len][2];
        for (int idx = 0; idx < len; idx++) Arrays.fill(mem[idx], -1);
        return Math.max(trav(nums, 0, true, mem), trav(nums, 0, false, mem));
    }

    private static int trav(int[] nums, int idx, boolean included, int[][] mem) {
        if (idx >= nums.length) return 0;
        int robV = included ? 1 : 0;
        if (mem[idx][robV] != -1) return mem[idx][robV];

        if (included) {
            return mem[idx][robV] = nums[idx] + trav(nums, idx + 1, false, mem);
        } else {
            return mem[idx][robV] = Math.max(trav(nums, idx + 1, true, mem), trav(nums, idx + 1, false, mem));
        }
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        int prevSecond = 0;
        int prevOne = nums[0];

        for (int i = 1; i < n; i++) {
            int include = nums[i] + prevSecond;
            int exclude = prevOne;

            int max = Math.max(include, exclude);

            prevSecond = prevOne;
            prevOne = max;
        }

        return prevOne;
    }
}
