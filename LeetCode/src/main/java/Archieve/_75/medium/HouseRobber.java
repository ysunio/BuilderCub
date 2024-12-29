package Archieve._75.medium;

import java.util.Arrays;

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] vDP = new int[nums.length];
        Arrays.fill(vDP, -1);
        return Math.max(rob(nums, 0, vDP), rob(nums, 1, vDP));
    }

    private int rob(int[] nums, int idx, int[] vDP) {
        if (idx >= nums.length) return 0;
        if (vDP[idx] != -1) return vDP[idx];
        return vDP[idx] = Math.max(nums[idx] + rob(nums, idx + 2, vDP), rob(nums, idx + 1, vDP));
    }
}
