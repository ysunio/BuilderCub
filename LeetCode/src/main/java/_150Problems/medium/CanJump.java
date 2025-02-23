package _150Problems.medium;

public class CanJump {

    // Backward
    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums[0] == 0) return false;
        int goal = nums.length - 1;

        // Iterate left, and validate if we can reach to chaning goal.
        for (int idx = nums.length - 1; idx >= 0; idx--) {
            if (idx + nums[idx] >= goal) {
                goal = idx;
            }
        }

        return goal == 0;
    }

    // Forward
    public boolean canJump2(int[] nums) {
        if (nums.length == 0 || nums[0] == 0) return false;
        int[] dp = new int[nums.length];
        return solve(nums, 0, dp);
    }

    private boolean solve(int[] nums, int idx, int[] dp){
        if(idx >= nums.length - 1) return true;

        if(dp[idx] != 0) return dp[idx] == 1;

        boolean isReachable = false;
        for(int t = 1; t <= nums[idx]; t++){
            isReachable |= solve(nums, idx + t, dp);
            if(idx + t < nums.length) dp[idx + t] = isReachable ? 1 : -1;
        }

        dp[idx] = isReachable ? 1 : -1;

        return isReachable;
    }

}
