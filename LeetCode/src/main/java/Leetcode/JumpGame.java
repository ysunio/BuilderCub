package Leetcode;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        int lastIndex = nums.length - 1;
        int maxReached = 0;
        for (int idx = 0; idx < nums.length; idx++) {
            if (maxReached < idx) return false;
            int nextExtremeJump = idx + nums[idx];
            if (nextExtremeJump > maxReached) maxReached = nextExtremeJump;
        }
        return maxReached >= lastIndex;
    }
}
