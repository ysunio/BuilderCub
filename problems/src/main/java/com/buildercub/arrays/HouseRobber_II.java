package com.buildercub.arrays;

import java.util.Arrays;

public class HouseRobber_II {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[][] vDP = new int[nums.length][2];
        for (int[] x : vDP) Arrays.fill(x, -1);

        return Math.max(rob(nums, 0, vDP, 1), rob(nums, 1, vDP, 0));
    }

    private int rob(int[] nums, int idx, int[][] vDP, int isStart) {
        if (idx >= nums.length) return 0;
        if (isStart == 1 && idx == nums.length - 1) return 0;
        if (vDP[idx][isStart] != -1) return vDP[idx][isStart];
        return vDP[idx][isStart] = Math.max(nums[idx] + rob(nums, idx + 2, vDP, isStart), rob(nums, idx + 1, vDP, isStart));
    }
}
