package com.buildercub.graphs;

public class UniquePath_II {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] dp = new int[grid.length][grid[0].length];
        System.out.println(uniquePath(grid, 0, 0, dp));
    }

    private static int uniquePath(int[][] grid, int x, int y, int[][] dp) {
        if (x >= grid.length || y >= grid[0].length || grid[x][y] == 1) return 0;
        if (x == grid.length - 1 && y == grid[0].length - 1) return 1;
        if (dp[x][y] != 0) return dp[x][y];
        return dp[x][y] = uniquePath(grid, x + 1, y, dp) + uniquePath(grid, x, y + 1, dp);
    }
}
