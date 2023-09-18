package Problems.easy;

public class ClimbStair {

    public static void main(String[] args) {
        System.out.println(climbStairs(10));
        System.out.println(climbStairsDp(10));
    }

    public static int climbStairs(int n) {
        int[] mem = new int[n + 1];
        return trav(n, 0, mem);
    }

    public static int climbStairsDp(int n) {
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        return dp[0];
    }


    private int trav(int n, int[] mem) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (mem[n] != 0) return mem[n];
        return mem[n] = trav(n - 1, mem) + trav(n - 2, mem);
    }

    private static int trav(int n, int idx, int[] mem) {
        if (idx == n) return 1;
        if (idx > n) return 0;
        if (mem[idx] != 0) return mem[idx];
        return mem[idx] = trav(n, idx + 1, mem) + trav(n, idx + 2, mem);
    }
}
