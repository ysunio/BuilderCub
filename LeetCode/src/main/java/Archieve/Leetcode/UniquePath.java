package Archieve.Leetcode;

import java.util.Arrays;

public class UniquePath {

    public static void main(String[] args) {
        System.out.println(uniquePaths(6, 6));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] x : dp) Arrays.fill(x, -1);
        return uniquePath(m - 1, n - 1, dp);
    }

    private static int uniquePath(int m, int n, int[][] dp) {
        if (m < 0 || n < 0) return 0;
        if (m == 0 && n == 0) return 1;
        if (dp[m][n] != -1) return dp[m][n];
        return dp[m][n] = uniquePath(m - 1, n, dp) + uniquePath(m, n - 1, dp);
    }
}
