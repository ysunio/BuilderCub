package _75.easy;

public class ClimbStair {
    public int climbStairs(int n) {
        int[] stairStore = new int[n + 1];
        stairStore[0] = 1; stairStore[1] = 1;
        for(int idx = 2; idx <= n; idx++)
            stairStore[idx] = stairStore[idx - 1] + stairStore[idx - 2];
        return stairStore[n];
    }
}
